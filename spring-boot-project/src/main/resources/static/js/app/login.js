const main = {
    // 초기화
    init() {
        const btnLogin = document.querySelector('#btn-login');
        if (btnLogin) btnLogin.addEventListener('click', () => this.login());

    },
    login() {
        console.log("login");
        const data = {
            userid: document.querySelector('#userid').value,
            pw: document.querySelector('#pw').value,
        };

        fetch('/log-in', {
            method: "POST",
            headers: {
                "Content-Type": "application/json; charset=utf-8",
            },
            body: JSON.stringify(data),
        })
        .then((response) => {
            if (response.status === 200 || response.status === 201) {
                alert("로그인 성공.");
                // userid를 세션에 저장
                sessionStorage.setItem('userid', data.userid);
                window.location.href = "/";
            } else {
                alert("로그인 실패.");
            }
        })
        .catch((error) => {
            alert(error.message);
        });
    },
};

main.init();
