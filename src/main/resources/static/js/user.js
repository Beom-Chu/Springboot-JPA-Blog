let index = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		});
		
		$("#btn-login").on("click", () => {
			this.login();
		});
	},

	save: function() {
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}

		console.log(data);

		$.ajax({
			type: "POST",
			url: "/api/user",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",	//요청 Body 타입
			dataType: "json"	//응답 타입
		}).done(function(resp) {
			
			console.log(resp);
			
			if(resp.status == 200){
				alert("회원가입이 완료되었습니다.");
				location.href = "/";
			} else {
				alert(resp.data);
			}

		}).fail(function(error) {

			alert(JSON.stringify(error));

		});
	},
	
	login: function() {
		let data = {
			username: $("#username").val(),
			password: $("#password").val()
		}

		console.log(data);

		$.ajax({
			type: "POST",
			url: "/api/user/login",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",	//요청 Body 타입
			dataType: "json"	//응답 타입
		}).done(function(resp) {
			
			console.log(resp);
			
			if(resp.status == 200){
				alert("로그인이 완료되었습니다.");
				location.href = "/";
			} else {
				alert(resp.data);
			}

		}).fail(function(error) {

			alert(JSON.stringify(error));

		});
	}
}


index.init();
