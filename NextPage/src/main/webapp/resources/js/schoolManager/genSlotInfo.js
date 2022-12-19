	
	/*addForm = $("#addForm");*/
	
	let mainImage = $("#mainImage").on("hidden.bs.modal", function(event){
			console.log("메인이미지닫힘");
			$(this).find(".modal-body").empty();
			
		}).on("show.bs.modal", function(event){
			console.log("메인이미지시작");
			let dataTr = event.relatedTarget;
			console.log(dataTr);
			let slotid = $(dataTr).data('bs-target'); //슬롯번호취득(footer)
			
			menuid = slotid.substr(1,slotid.length-1);
			console.log(slotid);
			console.log(menuid);
			viewForm.find('[name=menuid]').val(menuid);
			viewForm.submit();
			
			
			console.log("this : ", this.id);
			views = $(this);
			
		});

	
	let viewModal1 = $("#slot0011").on("hidden.bs.modal", function(event){
			console.log("모달닫힘1");
			$(this).find(".modal-body").empty();
			
		}).on("show.bs.modal", function(event){
			let dataTr = event.relatedTarget;
			console.log(dataTr);
			let slotid = $(dataTr).data('bs-target'); //슬롯번호취득
			
			menuid = slotid.substr(1,slotid.length-2);
			console.log(slotid);
			console.log(menuid);
			viewForm.find('[name=menuid]').val(menuid);
			viewForm.submit();
			
			
			console.log("this : ", this.id);
			views = $(this);
			console.log("모달열림1"); 
		});
	
	let viewModal2 = $("#slot0021").on("hidden.bs.modal", function(event){
		console.log("모달닫힘2");
		$(this).find(".modal-body").empty();
		
		}).on("show.bs.modal", function(event){
			let dataTr = event.relatedTarget;
			console.log(dataTr);
			let slotid = $(dataTr).data('bs-target'); //슬롯번호취득
			
			menuid = slotid.substr(1,slotid.length-2);
			console.log(slotid);
			console.log(menuid);
			viewForm.find('[name=menuid]').val(menuid);
			viewForm.submit();
			
			
			console.log("this : ", this.id);
			views = $(this);
			console.log("모달열림2"); 
		});
	
	let viewModal3 = $("#slot0031").on("hidden.bs.modal", function(event){
		console.log("모달닫힘3");
		$(this).find(".modal-body").empty();
		
		}).on("show.bs.modal", function(event){
			let dataTr = event.relatedTarget;
			console.log(dataTr);
			let slotid = $(dataTr).data('bs-target'); //슬롯번호취득
			
			menuid = slotid.substr(1,slotid.length-2);
			console.log(slotid);
			console.log(menuid);
			viewForm.find('[name=menuid]').val(menuid);
			viewForm.submit();
			
			
			console.log("this : ", this.id);
			views = $(this);
			console.log("모달열림3"); 
		});
	
	let viewModal4 = $("#slot0041").on("hidden.bs.modal", function(event){
		console.log("모달닫힘4");
		$(this).find(".modal-body").empty();
		
		}).on("show.bs.modal", function(event){
			let dataTr = event.relatedTarget;
			console.log(dataTr);
			let slotid = $(dataTr).data('bs-target'); //슬롯번호취득
			
			menuid = slotid.substr(1,slotid.length-2);
			console.log(slotid);
			console.log(menuid);
			viewForm.find('[name=menuid]').val(menuid);
			viewForm.submit();
			
			
			console.log("this : ", this.id);
			views = $(this);
			console.log("모달열림4"); 
		});
		
	let viewModal5 = $("#slot0051").on("hidden.bs.modal", function(event){
		console.log("모달닫힘5");
		$(this).find(".modal-body").empty();
		
		}).on("show.bs.modal", function(event){
			let dataTr = event.relatedTarget;
			console.log(dataTr);
			let slotid = $(dataTr).data('bs-target'); //슬롯번호취득
			
			menuid = slotid.substr(1,slotid.length-2);
			console.log(slotid);
			console.log(menuid);
			viewForm.find('[name=menuid]').val(menuid);
			viewForm.submit();
			
			
			console.log("this : ", this.id);
			views = $(this);
			console.log("모달열림5"); 
		});
		
	let viewModal6 = $("#slot0061").on("hidden.bs.modal", function(event){
		console.log("모달닫힘6");
		$(this).find(".modal-body").empty();
		
		}).on("show.bs.modal", function(event){
			let dataTr = event.relatedTarget;
			console.log(dataTr);
			let slotid = $(dataTr).data('bs-target'); //슬롯번호취득
			
			menuid = slotid.substr(1,slotid.length-2);
			console.log(slotid);
			console.log(menuid);
			viewForm.find('[name=menuid]').val(menuid);
			viewForm.submit();
			
			
			console.log("this : ", this.id);
			views = $(this);
			console.log("모달열림6"); 
		});
		
	let viewModal7 = $("#slot0071").on("hidden.bs.modal", function(event){
		console.log("모달닫힘7");
		$(this).find(".modal-body").empty();
		
		}).on("show.bs.modal", function(event){
			let dataTr = event.relatedTarget;
			console.log(dataTr);
			let slotid = $(dataTr).data('bs-target'); //슬롯번호취득
			
			menuid = slotid.substr(1,slotid.length-2);
			console.log(slotid);
			console.log(menuid);
			viewForm.find('[name=menuid]').val(menuid);
			viewForm.submit();
			
			
			console.log("this : ", this.id);
			views = $(this);
		console.log("모달열림7"); 
		});
	
	let viewModal8 = $("#slot0081").on("hidden.bs.modal", function(event){
		console.log("모달닫힘8");
		$(this).find(".modal-body").empty();
		
		}).on("show.bs.modal", function(event){
			let dataTr = event.relatedTarget;
			console.log(dataTr);
			let slotid = $(dataTr).data('bs-target'); //슬롯번호취득
			
			menuid = slotid.substr(1,slotid.length-2);
			console.log(slotid);
			console.log(menuid);
			viewForm.find('[name=menuid]').val(menuid);
			viewForm.submit();
			
			
			console.log("this : ", this.id);
			views = $(this);
			
			
		console.log("모달열림8"); 
		});
	
	let viewModal9 = $("#slot0091").on("hidden.bs.modal", function(event){
		console.log("모달닫힘9");
		$(this).find(".modal-body").empty();
		
		}).on("show.bs.modal", function(event){
			
			let dataTr = event.relatedTarget;
			console.log(dataTr);
			let slotid = $(dataTr).data('bs-target'); //슬롯번호취득
			
			menuid = slotid.substr(1,slotid.length-2);
			console.log(slotid);
			console.log(menuid);
			viewForm.find('[name=menuid]').val(menuid);
			viewForm.submit();
			
			
			console.log("this : ", this.id);
			views = $(this);
			
			
			console.log("모달열림9"); 
		});
		
	let viewModal10 = $("#slot0101").on("hidden.bs.modal", function(event){
		console.log("모달닫힘10");
		$(this).find(".modal-body").empty();
		
		}).on("show.bs.modal", function(event){
			let dataTr = event.relatedTarget;
			console.log(dataTr);
			let slotid = $(dataTr).data('bs-target'); //슬롯번호취득
			
			menuid = slotid.substr(1,slotid.length-2);
			console.log(slotid);
			console.log(menuid);
			viewForm.find('[name=menuid]').val(menuid);
			viewForm.submit();
			
			
			console.log("this : ", this.id);
			views = $(this);
		console.log("모달열림10"); 
		});
	
	let footer = $("#footer").on("hidden.bs.modal", function(event){
		console.log("footer닫힘");
		$(this).find(".modal-body").empty();
		
		}).on("show.bs.modal", function(event){
			console.log("푸터시작");
			let dataTr = event.relatedTarget;
			console.log(dataTr);
			let slotid = $(dataTr).data('bs-target'); //슬롯번호취득(footer)
			
			menuid = slotid.substr(1,slotid.length-1);
			console.log(slotid);
			console.log(menuid);
			viewForm.find('[name=menuid]').val(menuid);
			viewForm.submit();
			
			
			console.log("this : ", this.id);
			views = $(this);
			
		});
	
	let banner = $("#banner").on("hidden.bs.modal", function(event){
		console.log("banner닫힘");
		$(this).find(".modal-body").empty();
		
		}).on("show.bs.modal", function(event){
			console.log("banner시작");
			let dataTr = event.relatedTarget;
			console.log(dataTr);
			let slotid = $(dataTr).data('bs-target'); //슬롯번호취득(footer)
			
			menuid = slotid.substr(1,slotid.length-1);
			console.log(slotid);
			console.log(menuid);
			viewForm.find('[name=menuid]').val(menuid);
			viewForm.submit();
			
			
			console.log("this : ", this.id);
			views = $(this);
			
		});
	
	
	
	
	let schLogo = $("#schLogo").on("hidden.bs.modal", function(event){
		console.log("schLogo닫힘");
		$(this).find(".modal-body").empty();
		
		}).on("show.bs.modal", function(event){
			console.log("schLogo시작");
			let dataTr = event.relatedTarget;
			console.log(dataTr);
			let slotid = $(dataTr).data('bs-target'); //슬롯번호취득(footer)
			
			menuid = slotid.substr(1,slotid.length-1);
			console.log(slotid);
			console.log(menuid);
			viewForm.find('[name=menuid]').val(menuid);
			viewForm.submit();
			
			
			console.log("this : ", this.id);
			views = $(this);
			
		});
	

	let viewForm = $("#viewForm").on("submit", function(event){
		console.log("뷰 전송처음");
		event.preventDefault();
		let url = this.action;
		let method = this.method;
		let data = $(this).serialize(); // ajaxForm 적용
		console.log(url);
		console.log(method);
		console.log(data);
		
		$.ajax({ 
			url : url,
			method : method,
			data : data,
			dataType : "html",
			success : function(resp) {
				views.find(".modal-body").html(resp);
			},
			error : function(errorResp) {
				console.log(errorResp.status);
				views.find(".modal-body").html(errorResp.responseText);
			}
		});
		return false;
	});
	
	
	
	
	
	let addBtn = $(".addBtn").on("click", function(event){
 		console.log("addBtn눌림");
 		
 		alertFiles = document.getElementsByClassName('alertFiles');
 		logoFile = document.getElementsByClassName('logoFile');
 		mainFile = document.getElementsByClassName('addImage');
 		
 		addForm = $("#addForm");
 		
 		/*let url = "/NextPage/school/manager/slot/add";
		let method = "post";
		let data = $("#addForm").serialize();*/
 		
 		//let url = addForm[0].action;
 		let url = "/NextPage/school/manager/slot/add";
 		let method = addForm[0].method;
 		let data = addForm.serialize();
 		
 		let lkData = "";
 		
 		console.log(testArr);
 		for(var i = 0 ; i < testArr.length ; i++){
 			if(i==0){
 				lkData += "lkWidget="+testArr[i];
 			}else{
 				lkData += "&lkWidget="+testArr[i];
 			}
 		}
 		if(testArr.length>0){
 			data = lkData + "&" +data;
 		} 
 		beforeAlert = document.getElementsByClassName('alertData');
 		beforeLogo = document.getElementsByClassName('beforeLogo');
 		beforeMain = document.getElementsByClassName('beforeMain');
 		
 		let alertData = "";
 		let imageData = "";
 		//console.log(ac[0].files[0].name);
 		
 		//console.log("로고제목 : ",logoFile[0].files[0].name);
 		
 		//console.log(logFile);
 		
 		for(var b = 0 ; b < mainFile.length; b++){
 			console.log(b+"번째", mainFile[b].files[0]);
 			if(b==0){
 				if(mainFile[b].files[0]==undefined){
 					imageData += "mainFiles=" + beforeMain[b].value;
 				}else{
 					imageData += "mainFiles=" + mainFile[b].files[0].name;
 				}
 			}else{
 				if(mainFile[b].files[0]==undefined){
 					imageData += "&mainFiles=" + beforeMain[b].value;
 				}else{
 					imageData += "&mainFiles=" + mainFile[b].files[0].name;
 				}
 			}
 		}
 		
 		if(imageData.length>0){
 			data = imageData;
 		}
 		
 		
 		for(var a = 0 ; a < logoFile.length; a++){
 			if(logoFile[a].files[0] == undefined){
 	 			data += "logoData="+beforeLogo[a].value;
 	 		}else{
 	 			data += "logoData="+logoFile[a].files[0].name;
 	 		}
 		}
 		
 		for(var j = 0 ; j < alertFiles.length ; j++){
 			console.log(j+"번째",alertFiles[j].files[0]);
 			if(j==0){ 
 				if(alertFiles[j].files[0]==undefined){
 					alertData += "alertFiles=" + beforeAlert[j].value ;
 				}else{
 					alertData += "alertFiles="+ alertFiles[j].files[0].name;
 				}
 			}else{
 				if(alertFiles[j].files[0]==undefined){
 					alertData += "&alertFiles=" + beforeAlert[j].value ;
 				}else{
 					alertData += "&alertFiles="+ alertFiles[j].files[0].name;
 				}
 			}
 		}
 		
 		if(alertData.length>0){
 			data = alertData + "&" + data;
 		}
 		
 		
 		
 		
 		console.log(alertData);
 		console.log("^^: ", lkData);
 		
		console.log(url, method, data);
		
		 
		$.ajax({  
			url : url,
			method : method,
			data : data,
			dataType : "html",
			success : function(resp) {
				//viewModal.find(".modal-body").html(resp);
				//console.log("성공");
				location.reload();
				$(".modal").modal("hide");
			},
			error : function(errorResp) {
				console.log(errorResp.status);
				//viewModal.find(".modal-body").html(errorResp.responseText);
			}
		});
 	});

