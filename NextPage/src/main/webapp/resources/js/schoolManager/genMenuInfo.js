	
	let addForm = $("#addForm");
	
	menuType = "noType";
	secondNum = ""; 
	
	changeSecondMenu = $("#searchMenu").on("change", "[name=menuName]", function(event){
		secondNum = $(this).val(); 
		console.log("두번째 옵션 선택", secondNum);
	})
	
	
	searchMenu = $("#searchMenu").on("change", "[name=menuType]", function(event){
			menuType = $(this).val();
	}) 
	
	
	let delBtn = $("#delBtn").on("click", function(event){
		console.log("삭제버튼시작");
		
		console.log("글번호:",idVal);
		
		let url = "/NextPage/school/manager/menu/delete";
		let method = "post";
		let data = {
				  menuId : idVal
		};
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
				viewModal.find(".modal-body").html(errorResp.responseText);
			}
		});
	})
	
	let updateBtn = $("#updateBtn").on("click", function(event){
 		console.log("updateBtn눌림");
 		
 		menuNm = $("#menuNm").val();
 		
 		var radioCheck = $('input[name=radioList]:checked').val();
 		console.log("라디오 체크", radioCheck);
 		
 		//var MenuLink = $("#menuLink").val();
 		var MenuLink ="";
 		if(menuType=="link"){
 			MenuLink = $("#menuLink").val();
 		}else{
 			MenuLink = $(":input[id='menuLink']").attr("value");
 		}
 		
 		if(menuType=="board" || menuType=="contents"){
 			secondNum = $("select[name=menuName] option:selected").val();
 		}
 		
 		
 		//secondNum = $("select[name=menuName] option:selected").val();
 		console.log("글번호", secondNum);
 		
 		
 		var send_array = [];
 		var send_cnt = 0;
 		//var chkbox = $(".checkSelect");
 		var chkbox = $("input[name='box[]']:checked");
 		
 		for(i=0;i<chkbox.length;i++) {
 		    if (chkbox[i].checked == true){
 		        send_array[send_cnt] = chkbox[i].value;
 		        send_cnt++;
 		    }
 		}
 		console.log(send_array);
 		
 		let url = "/NextPage/school/manager/menu/update";
		let method = "post";
		let data = {
				  menuId : idVal
				, menuNm : menuNm
				, checkList : send_array
				, menuUseOk : radioCheck
				, menuLink : MenuLink+secondNum
				, menuType : menuType
		};
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
				viewModal.find(".modal-body").html(errorResp.responseText);
			}
		});
 	});
	
	
 	let addBtn = $("#addBtn").on("click", function(event){
 		console.log("addBtn눌림");
 		
 		menuNm = $("#menuNm").val();
 		
 		var radioCheck = $('input[name=radioList]:checked').val();
 		console.log("라디오 체크", radioCheck);
 		
 		var menuLink = $("#menuLink").val();
 		if(menuType=="board" || menuType=="contents"){
 			secondNum = $("select[name=menuName] option:selected").val();
 		}
 		console.log("글번호", secondNum);
 		
 		var send_array = [];
 		var send_cnt = 0;
 		var chkbox = $("input[name='box[]']:checked");
 		
 		//console.log(chkbox);
 		
 		for(i=0;i<chkbox.length;i++) {
 		    if (chkbox[i].checked == true){
 		        send_array[send_cnt] = chkbox[i].value;
 		        send_cnt++;
 		    }
 		}
 		
 		console.log(send_array);
 		
 		let url = "/NextPage/school/manager/menu/add";
		let method = "post";
		let data = {
				TopMenuId : idVal
				, menuNm : menuNm
				, checkList : send_array
				, menuUseOk : radioCheck
				, menuLink : menuLink+secondNum
				, menuType : menuType
		};
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
				viewModal.find(".modal-body").html(errorResp.responseText);
			}
		});
 	});

	let viewModal = $("#exampleModal").on("hidden.bs.modal", function(event){
		$(this).find(".modal-body").empty();
		viewForm.get(0).reset();
		viewModal.data("menuid", "");
		
	}).on("show.bs.modal", function(event){
		let dataTr = event.relatedTarget;
		let menuid = $(dataTr).data('menuid');
		viewModal.data("menuid", menuid);
		viewForm.find('[name=menuid]').val(menuid);
		addForm.find('[name=menuid]').val(menuid);
		
		idVal = $(this).data('menuid'); //id값 출력
		
		viewForm.submit();
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
				viewModal.find(".modal-body").html(resp);
			},
			error : function(errorResp) {
				console.log(errorResp.status);
				viewModal.find(".modal-body").html(errorResp.responseText);
			}
		});
		return false;
	});
	
	
let viewModal2 = $("#exampleModal2").on("hidden.bs.modal", function(event){
		console.log("폼2 사라짐");
		console.log(event.target);
		$(this).find(".modal-body").empty();
		viewForm2.get(0).reset();
		viewModal2.data("menuid", "");
		
	}).on("show.bs.modal", function(event){
		console.log("폼2 나타남");
		let dataTr = event.relatedTarget;
		let menuid = $(dataTr).data('menuid');
		viewModal2.data("menuid", menuid);
		viewForm2.find('[name=menuid]').val(menuid);
		
		idVal = $(this).data('menuid'); //id값 출력
		
		updateVal = $(this).data('menuid'); //id값 출력
	
		viewForm2.submit();
	});
	
let viewForm2 = $("#viewForm2").on("submit", function(event){
	console.log("update 뷰 전송처음");
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
			viewModal2.find(".modal-body").html(resp);
		},
		error : function(errorResp) {
			console.log(errorResp.status);
			viewModal2.find(".modal-body").html(errorResp.responseText);
		}
	});
	return false;
});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	$(function() {

	    $("#itemBoxWrap").sortable({

	        placeholder:"itemBoxHighlight",

	        start: function(event, ui) {

	            ui.item.data('start_pos', ui.item.index());

	        },

	        stop: function(event, ui) {

	            var spos = ui.item.data('start_pos');

	            var epos = ui.item.index();

		    reorder();

	        }

	    });
 
	});
	
	function reorder() {

	    $(".itemBox").each(function(i, box) {

	        $(box).find(".itemNum").html(i + 1);

	    }); 

	}
	
	$(function() {

	    $("#topul").sortable();
	   // $(".menu1").sortable();
	    $("#topul").disableSelection();

	});