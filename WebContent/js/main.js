$(document).ready(function() {
	$("input").dblclick(function() {
		$(this).removeAttr('readonly');
		$(this).blur(function() {
			$(this).attr('readonly', 'readonly');
		});

	});
});
// 通过ID删除一个用户
function deleteById(id) {
	$.ajax({
		url : 'userdelete.action',
		async : false,
		type : 'post',
		dataType : 'json',
		data : {
			'uid' : id
		},
		success : success_function,
		error : error_function
	});
	function success_function(message) {
		if ('1' == message) {
			document.location.reload();// 当前页面
		}
	}
	function error_function() {
		alert("删除成功！！");
	}
}

// 通过ID更新的用户信息
function update(id) {
	// if(typeof($("input").attr("readonly"))=="undefined"){
	// }
	$(this).attr('readonly', 'readonly');
	var $clas = $('.use' + id);
	$.ajax({
		url : 'userupdate.action',
		async : false,
		type : 'post',
		dataType : 'json',
		data : {
			'uid' : id,
			'uname' : $clas.eq(1).val(),
			'upassword' : $clas.eq(2).val()
		},
		success : success_function,
		error : error_function
	});
	function success_function(message) {
		if ('1' == message) {
			document.location.reload();// 当前页面
		}
	}
	function error_function() {
		alert("删除失败！！");
	}
}
// 添加新的用户
function add(id) {
	$.ajax({
		url : 'userinsert.action',
		async : false,
		type : 'post',
		data : {
			'uname' : $('.usename').val(),
			'upassword' : $('.uspwd').val()
		},
		dataType : 'json',
		success : success_function,
		error : error_function
	});
	function success_function(message) {
		if ('1' == message) {
			document.location.reload();// 当前页面
		}
	}
	function error_function() {
		alert("添加失败！！");
	}
}
// 添加用户表格
function insert() {
	var arr = "<tr>" + "<td>" + "" + "</td>" + "<td>"
			+ "<input class='usename' type='text'>" + "</td>" + "<td>"
			+ "<input class='uspwd' type='text'>" + "</td>" + "<td>"
			+ "<a href='javascript:;' onclick='add()'>添加</a>" + "</td>"
			+ "</tr>";
	$("table").append(arr);

}