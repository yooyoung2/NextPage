/**
 * 공지사항리스트에서
 * 수정, 삭제로 가기 위한 js
 */

 	let updateForm = $("#updateForm");
 	let updateBtn = $("#updateBtn").on("click", function(event){
 		let who = viewModal.data("who");
 		if(!who) return false;
 		updateForm.get(0).who.value = who;
	 	updateForm.submit();
 	});
 	let deleteForm = $("#deleteForm");
 	let deleteBtn = $("#deleteBtn").on("click", function(event){
 		let who = viewModal.data("who");
 		if(!who) return false;
 		if(confirm("진짜 삭제할까?")){
	 		deleteForm.get(0).who.value = who;
	 		deleteForm.submit();
 		}
 	});

	let viewForm = $("#viewForm").on("submit", function(event){
		event.preventDefault();
		let url = this.action;
		let method = this.method;
		let data = $(this).serialize(); // ajaxForm 적용
		$.ajax({
			url : url,
			method : method,
			data : data,
			dataType : "html",
			success : function(resp) {
				viewModal.find(".modal-body").html(resp);
			},
			error : function(errorResp) {
				console.log(errorResp.status);
				viewModal.find(".modal-body").html(errorResp.responseText);
			}
		});
		return false;
	});