
	let viewModal = $("#exampleModal").on("hidden.bs.modal", function(event){
		console.log("폼이 닫힘.");
		$(this).find(".modal-body").empty();
		viewForm.get(0).reset();
		viewModal.data("menuId", "");
	}).on("show.bs.modal", function(event){
		console.log("폼이 열림");
		let dataTr = event.relatedTarget;
		let menuId = $(dataTr).data('menuId');
		viewModal .data("menuId", menuId);
		viewForm.find('[name=menuId]').val(menuId);
		viewForm.submit(); 
	});
	let viewForm = $("#viewForm").on("submit", function(event){
		console.log("뷰 전송처음");
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