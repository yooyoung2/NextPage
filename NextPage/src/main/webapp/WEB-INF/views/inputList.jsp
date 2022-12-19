<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<style>
    .eunbi {
        border:1px solid black;
    }
</style>
</head>
<body>
    <input type="button" value="추강"  onclick="f_add()">
    <input type="button" value="떤쏭" onclick="f_send()">
    <div id="disp">
        <div class="eunbi">
	            학생이름: <input type="text" name="nm_name" value=""><br>
	            학생학번: <input type="text" name="nm_num" value=""><br>
        </div>
    </div>
<script>
    let ldisp = document.querySelector("#disp");
    let leunbi = document.querySelector(".eunbi");

    const addBtn = document.createElement("button");
    const newText = document.createTextNode('삭제');


    function f_add(){
        let leunbiClone = leunbi.cloneNode(true);
        ldisp.appendChild(leunbiClone);
        ldisp.appendChild(addBtn);
    }

    function f_send(){
        // 먼저 보낼 데이터 형식으로 만들어야 함,  [{hname:,hbun:}.....]
        let eunbiList = document.querySelectorAll(".eunbi");
        let ldataList = [];
        for(let i=0; i<eunbiList.length; i++){
            console.log(eunbiList[i].children[1]);
            let hakseng = {};
            hakseng.name = eunbiList[i].children[0].value;
            hakseng.bunho = eunbiList[i].children[2].value;
            ldataList.push(hakseng);
        }

        console.log(ldataList); // 항상 중간 중간에 누느로 데이터를 화긴하는 습관!

        $.ajax({
            type:"post",
            url:"/NextPage/merong/getList",
            data: JSON.stringify(ldataList),
            contentType:"application/json; charset=utf-8",
            dataType:"json", // 받은 데이터에 JSON.parse를 할지 말징
            success: function(data){
                console.log(data);
                console.log(JSON.parse(data));
            },
            error:function(error){
            	Swal.fire({
      			  position: 'top-end',
      			  icon: 'success',
      			  title: error,
      			  showConfirmButton: false,
      			  timer: 1500
      			});
            }
        })
    }

</script>
</body>
</html>