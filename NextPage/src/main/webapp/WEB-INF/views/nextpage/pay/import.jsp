
<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	
	<h1> 아임포트 테스트 </h1>
 
 	 <button onclick="requestPay()">결제하기</button>

  <script>
  var IMP = window.IMP;
  IMP.init("imp77053745"); // "iamport" 대신 발급받은 "가맹점 식별코드"를 사용합니다
  
    function requestPay() {
      // IMP.request_pay(param, callback) 결제창 호출
      IMP.request_pay({ // param
          pg: "html5_inicis",
          pay_method: "card",
          merchant_uid: "ORD20180131-0000011",
          name: "노르웨이 회전 의자",
          amount: 64900,
          buyer_email: "gildong@gmail.com",
          buyer_name: "홍길동",
          buyer_tel: "010-4242-4242",
          buyer_addr: "서울특별시 강남구 신사동",
          buyer_postcode: "01181"
      }, function (rsp) { // callback
          if (rsp.success) {
              ...,
              // 결제 성공 시 로직,
              ...
          } else {
              ...,
              // 결제 실패 시 로직,
              ...
          }
      });
    }
    
    IMP.request_pay({
        /* ...중략... */
      }, function (rsp) { // callback
        if (rsp.success) { // 결제 성공 시: 결제 승인 또는 가상계좌 발급에 성공한 경우
          // jQuery로 HTTP 요청
          jQuery.ajax({
              url: "{서버의 결제 정보를 받는 endpoint}", // 예: https://www.myservice.com/payments/complete
              method: "POST",
              headers: { "Content-Type": "application/json" },
              data: {
                  imp_uid: rsp.imp_uid,
                  merchant_uid: rsp.merchant_uid
              }
          }).done(function (data) {
            // 가맹점 서버 결제 API 성공시 로직
          })
        } else {
          alert("결제에 실패하였습니다. 에러 내용: " +  rsp.error_msg);
        }
      });
    
    
    app.use(bodyParser.json());
    // "/payments/complete"에 대한 POST 요청을 처리
    app.post("/payments/complete", async (req, res) => {
      try {
        const { imp_uid, merchant_uid } = req.body; // req의 body에서 imp_uid, merchant_uid 추출
      } catch (e) {
        res.status(400).send(e);
      }
    });
    
    
    app.use(bodyParser.json());
    ...
    // "/payments/complete"에 대한 POST 요청을 처리
    app.post("/payments/complete", async (req, res) => {
      try {
        const { imp_uid, merchant_uid } = req.body; // req의 body에서 imp_uid, merchant_uid 추출
        ...
        // 액세스 토큰(access token) 발급 받기
        const getToken = await axios({
          url: "https://api.iamport.kr/users/getToken",
          method: "post", // POST method
          headers: { "Content-Type": "application/json" }, // "Content-Type": "application/json"
          data: {
            imp_key: "imp_apikey", // REST API 키
            imp_secret: "ekKoeW8RyKuT0zgaZsUtXXTLQ4AhPFW3ZGseDA6bkA5lamv9OqDMnxyeB9wqOsuO9W3Mx9YSJ4dTqJ3f" // REST API Secret
          }
        });
        const { access_token } = getToken.data.response; // 인증 토큰
        ...
        // imp_uid로 아임포트 서버에서 결제 정보 조회
        const getPaymentData = await axios({
          url: \`https://api.iamport.kr/payments/\${imp_uid}\`, // imp_uid 전달
          method: "get", // GET method
          headers: { "Authorization": access_token } // 인증 토큰 Authorization header에 추가
        });
        const paymentData = getPaymentData.data.response; // 조회한 결제 정보
        ...
      } catch (e) {
        res.status(400).send(e);
      }
    });
    
    
    app.use(bodyParser.json());
    ...
    // "/payments/complete"에 대한 POST 요청을 처리
    app.post("/payments/complete", async (req, res) => {
      try {
        const { imp_uid, merchant_uid } = req.body; // req의 body에서 imp_uid, merchant_uid 추출
        // 액세스 토큰(access token) 발급 받기
        /* ...중략... */
        // imp_uid로 아임포트 서버에서 결제 정보 조회
        /* ...중략... */
        const paymentData = getPaymentData.data.response; // 조회한 결제 정보
        ...
        // DB에서 결제되어야 하는 금액 조회
        const order = await Orders.findById(paymentData.merchant_uid);
        const amountToBePaid = order.amount; // 결제 되어야 하는 금액
        ...
        // 결제 검증하기
        const { amount, status } = paymentData;
        if (amount === amountToBePaid) { // 결제금액 일치. 결제 된 금액 === 결제 되어야 하는 금액
          await Orders.findByIdAndUpdate(merchant_uid, { $set: paymentData }); // DB에 결제 정보 저장
          ...
          switch (status) {
            case "ready": // 가상계좌 발급
              // DB에 가상계좌 발급 정보 저장
              const { vbank_num, vbank_date, vbank_name } = paymentData;
              await Users.findByIdAndUpdate("/* 고객 id */", { $set: { vbank_num, vbank_date, vbank_name }});
              // 가상계좌 발급 안내 문자메시지 발송
              SMS.send({ text: \`가상계좌 발급이 성공되었습니다. 계좌 정보 \${vbank_num} \${vbank_date} \${vbank_name}\`});
              res.send({ status: "vbankIssued", message: "가상계좌 발급 성공" });
              break;
            case "paid": // 결제 완료
              res.send({ status: "success", message: "일반 결제 성공" });
              break;
          }
        } else { // 결제금액 불일치. 위/변조 된 결제
          throw { status: "forgery", message: "위조된 결제시도" };
        }
      } catch (e) {
        res.status(400).send(e);
      }
    });
    
    IMP.request_pay({
        /* ...중략... */
      }, function (rsp) { // callback
        if (rsp.success) { // 결제 성공 시: 결제 승인 또는 가상계좌 발급에 성공한 경우
            // jQuery로 HTTP 요청
            jQuery.ajax({
              /* ...중략... */
            }).done(function(data) { // 응답 처리
              switch(data.status) {
                case: "vbankIssued":
                  // 가상계좌 발급 시 로직
                  break;
                case: "success":
                  // 결제 성공 시 로직
                  break;
              }
            });
        } else {
          alert("결제에 실패하였습니다. 에러 내용: " +  rsp.error_msg);
        }
      });
    
    
    app.use(bodyParser.json());
    ...
    // "/iamport-webhook"에 대한 POST 요청을 처리
    app.post("/iamport-webhook", async (req, res) => {
      try {
          const { imp_uid, merchant_uid } = req.body; // req의 body에서 imp_uid, merchant_uid 추출
          // 액세스 토큰(access token) 발급 받기
          /* ...중략... */
          // imp_uid로 아임포트 서버에서 결제 정보 조회
          /* ...중략... */
          const paymentData = getPaymentData.data.response; // 조회한 결제 정보
          ...
          // DB에서 결제되어야 하는 금액 조회
          const order = await Orders.findById(paymentData.merchant_uid);
          const amountToBePaid = order.amount; // 결제 되어야 하는 금액
          ...
          // 결제 검증하기
          const { amount, status } = paymentData;
          if (amount === amountToBePaid) { // 결제금액 일치. 결제 된 금액 === 결제 되어야 하는 금액
            await Orders.findByIdAndUpdate(merchant_uid, { $set: paymentData }); // DB에 결제 정보 저장
            switch (status) {
              case "ready": // 가상계좌 발급
                // DB에 가상계좌 발급 정보 저장
                const { vbank_num, vbank_date, vbank_name } = paymentData;
                await Users.findByIdAndUpdate("/* 고객 id */", { $set: { vbank_num, vbank_date, vbank_name }});
                // 가상계좌 발급 안내 문자메시지 발송
                SMS.send({ text: \`가상계좌 발급이 성공되었습니다. 계좌 정보 \${vbank_num} \${vbank_date} \${vbank_name}\`});
                res.send({ status: "vbankIssued", message: "가상계좌 발급 성공" });
                break;
              case "paid": // 결제 완료
                res.send({ status: "success", message: "일반 결제 성공" });
                break;
            }
          } else { // 결제금액 불일치. 위/변조 된 결제
            throw { status: "forgery", message: "위조된 결제시도" };
          }
      } catch (e) {
        res.status(400).send(e);
      }
    });
  </script>
