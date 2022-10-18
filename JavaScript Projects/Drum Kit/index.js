let numberDrumBtns = document.querySelectorAll(".drum").length;
let audio = new Audio();

for (let i = 0; i < numberDrumBtns; i++) {
    
    document.querySelectorAll(".drum")[i].addEventListener("click", function(){
        let buttonInnerHtml = this.innerHTML;
        makeSound(buttonInnerHtml);
    });
};


document.addEventListener("keypress", function(event){
    makeSound(event.key);
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