//注册
function register() {
	var data = {
		uname : $('#code').val(),
		upassword : $('#pwd').val()
	};
	$.ajax({
		url : 'userfindByName.action',
		type : 'post',
		dataType : 'text',
		data : data,
		success : success_user,
		error : error_user
	});

	function success_user(message) {
		$('#message').html(message);
	}

	function error_user() {
		alert("存在错误！！！");
	}

}