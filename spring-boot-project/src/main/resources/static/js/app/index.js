const main = {
    search() {
              const searchBox = document.getElementById("search-box");
              const searchQuery = searchBox.value;
              window.location.href = `http://192.168.0.193:8000/map/?search=${searchQuery}`;

            },
    // 초기화
    init() {

        const btnSave =document.querySelector('#btn-save');
        if(btnSave) btnSave.addEventListener('click',()=>this.save());

        const btnUpdate =document.querySelector('#btn-update');
        if(btnUpdate) btnUpdate.addEventListener('click',()=>this.update());

        const btnDelete =document.querySelector('#btn-delete');
        if(btnDelete) btnDelete.addEventListener('click',()=>this.delete());

    },

    // 데이터 저장
    save() {
        console.log("save");
        const data = {
            title: document.querySelector('#title').value,
            author: document.querySelector('#author').value,
            content: document.querySelector('#content').value,
            climbing_mountain: document.querySelector('#climbing_mountain').value,
            climbing_date: document.querySelector('#climbing_date').value,
        };
        // fetch API를 이용해서 POST 요청을 보내고 그 결과를 처리
        fetch('/api/v1/posts', {
            method: "POST",
            headers: {
                "Content-Type":"application/json;charset=utf-8",
            },
            body: JSON.stringify(data),
        })
        .then((response) => {
            if(response.status===200||response.status===201) {
                // 저장 성공
                alert("글이 등록되었습니다.");
                window.location.href="/";
            } else {
                // 저장 실패
                alert("오류가 1.");
            }
        })
        .catch((error) => {
            // 네트워크 오류 등 예외 발생
            alert(error.message)
        });
    },

    update() {
        const data = {
            title: document.querySelector("#title").value,
            content: document.querySelector("#content").value,
            climbing_mountain: document.querySelector('#climbing_mountain').value,
            climbing_date: document.querySelector('#climbing_date').value,
        };

       const id = document.querySelector("#id").value;
       fetch(`/api/v1/posts/${id}`, {
            method: "PUT",
            headers: {
                       "Content-Type":"application/json;char=utf-8",
            },
            body: JSON.stringify(data),
       }).then((response) => {
             if(response.status===200||response.status===201) {
                 // 수정 성공
                 alert("글이 수정되었습니다.");
                 window.location.href="/";
             } else {
                 // 수정 실패
                 alert("오류가 2.");
             }
       })
       .catch((error) => {
                   // 네트워크 오류 등 예외 발생
                   alert(error.message)
       });
    },
    //데이터 삭제
    delete() {
        const id = document.querySelector("#id").value;
        fetch(`/api/v1/posts/${id}`, {
                    method: "DELETE",

        }).then((response) => {
            if(response.status===200||response.status===201) {
            // 삭제 성공
            alert("글이 삭제되었습니다.");
            window.location.href="/";
            } else {
            // 삭제 실패
            alert("오류가 3.");
            }
            })
            .catch((error) => {
            // 네트워크 오류 등 예외 발생
            alert(error.message)
       })
    },


}

main.init();