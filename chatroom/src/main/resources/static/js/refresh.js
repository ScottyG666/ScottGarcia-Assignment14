
document.querySelector('#fetchBtn').addEventListener('click' , () => {
    
    var pathURL = window.location.pathname + '/retrieveMessages'
    fetch(pathURL )
        .then(returned => returned.json())
        .then( data => {
            //console.log(data)
        })

    })