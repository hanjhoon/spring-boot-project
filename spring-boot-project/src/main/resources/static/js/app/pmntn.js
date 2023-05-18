const main={
    init(){
//        const pageminus = document.querySelector('#pageminus');
//        if(pageminus) pageminus.addEventListener('click', () => this.addpage());
        const previouspage = document.getElementById('previouspage');


        // Add a click event listener to the button
        previouspage.addEventListener('click', function() {
          // Get the current URL
          let url = new URL(window.location.href);
          const searchParam = url.searchParams;
          const pagenm = searchParam.get('pagenm');
          console.log(pagenm);

          // Set the value of the "page" query parameter to "2"
          searchParam.set('pagenm', pagenm-1);

          // Update the URL with the new query parameter value
          window.history.pushState({}, '', url);
        });

        const nextpage = document.getElementById('nextpage');
        // Add a click event listener to the button
        nextpage.addEventListener('click', function() {
          // Get the current URL
          let url = new URL(window.location.href);
          const searchParam = url.searchParams;
          const pagenm = searchParam.get('pagenm');
          console.log(pagenm);

          // Set the value of the "page" query parameter to "2"
          searchParam.set('pagenm', pagenm+1);

          // Update the URL with the new query parameter value
          window.history.pushState({}, '', url);
        });
    },



}