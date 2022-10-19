let numberDrumBtns = document.querySelectorAll(".drum").length;
let audio = new Audio();

for (let i = 0; i < numberDrumBtns; i++) {
    
    document.querySelectorAll(".drum")[i].addEventListener("click", function(){
        let buttonInnerHtml = this.innerHTML;
        makeSound(buttonInnerHtml);
        buttonAnimation(buttonInnerHtml);
    });
};


document.addEventListener("keypress", (e) => {
    makeSound(e.key);
    buttonAnimation(e.key);
});

function makeSound(key){
    switch(key){
        case "w":
            audio = new Audio("sounds/tom-1.mp3");
        break;
        case "a":
            audio = new Audio("sounds/tom-2.mp3");
        break;
        case "s":
            audio = new Audio("sounds/tom-3.mp3");
        break;
        case "d":
            audio = new Audio("sounds/tom-4.mp3");
        break;
        case "j":
            audio = new Audio("sounds/snare.mp3");
        break;
        case "k":
            audio = new Audio("sounds/crash.mp3");
        break;
        case "l":
            audio = new Audio("sounds/kick-bass.mp3");
        break;
    }
    audio.play();
}

function buttonAnimation(key){
    let activeBtn = document.querySelector("." + key);
    activeBtn.classList.toggle("pressed");

    setTimeout(function(){
        activeBtn.classList.remove("pressed")
    }, 150);
}