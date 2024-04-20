let messageSpace = document.querySelector("#messageSpace");
let emojiBtn = document.querySelector(".emoji-btn");

emojiBtn.addEventListener("click", function() {
    messageSpace.value += "😊"; 
    messageSpace.focus(); 
});

let id = document.querySelector('textarea[data-id]')

let channelId = (id.getAttribute('data-id'))
let userData = sessionStorage.getItem('user')

if(userData === null){
    window.location.replace('/welcome')
}

let user = JSON.parse(sessionStorage.getItem('user'))

messageSpace.addEventListener('keydown', (x) => {
    if(x.key === `Enter`){
        var message = {
            "text" : messageSpace.value,
            "user" : user,
            "channelId" : channelId
        }
        console.log(JSON.stringify(message))
        x.preventDefault();
        messageSpace.value = '';
        fetch(`http://localhost:8080/messages`,{
            method: "POST",
            headers: {
                "Content-Type" : "application/json"
            },
            body: JSON.stringify(message)
        })
    }
})

function getMessages(){
    let messageBox = document.querySelector("#messages")
    fetch(`http://localhost:8080/messages/${channelId}`)
    .then(response => response.json())
    .then(data =>{
        messageBox.innerHTML = ''
        data.forEach(message => {
            messageBox.innerHTML += `<div>
                    <span>${message.user.name}: ${message.text}</span>
                    </div>`
        })
    })
}

setInterval(getMessages, 500)
