let numberBtns = document.querySelectorAll(".btn").length;
let audio = new Audio();
let gamePattern = [];
let userClickedPattern = [];
let gameStarted = false; 
let level = 1;
let title = document.querySelector("#level-title");

let btnColours = ["red", "blue", "green", "yellow"];
let userChosenColor;

function makeSound(key){
    switch(key){
        case "green":
            audio = new Audio("sounds/green.mp3");
        break;
        case "red":
            audio = new Audio("sounds/red.mp3");
        break;
        case "yellow":
            audio = new Audio("sounds/yellow.mp3");
        break;
        case "blue":
            audio = new Audio("sounds/blue.mp3");
        break;
    }
    audio.play();
    audio = new Audio();
}

function buttonAnimation(key){
    let activeBtn = document.querySelector("." + key);
    activeBtn.classList.toggle("pressed");

    setTimeout(function(){
        activeBtn.classList.remove("pressed")
    }, 150);
}

function nextSequence(){
    let randomNumber = Math.floor(Math.random() * 4);
    let randomChosenColor = btnColours[randomNumber];
    gamePattern.push(randomChosenColor);
    setTimeout(() => {
        makeSound(gamePattern[gamePattern.length - 1]);
        buttonAnimation(gamePattern[gamePattern.length - 1]);
    }, 1000)
    title.innerText = "Level " + level;
    level++;
}

function gameStart(){
    if(!gameStarted){
        gamePattern = [];
        userClickedPattern = [];
        gameStarted = true;
        nextSequence();
    }
}

function checkAnswer(currentLevel){
    if(userClickedPattern[currentLevel] === gamePattern[currentLevel] && currentLevel === gamePattern.length -1){
        setTimeout(nextSequence(), 1000)
        userClickedPattern = [];
    }else if(userClickedPattern[currentLevel] === gamePattern[currentLevel] && currentLevel < gamePattern.length-1){
        return;
    }else{
        let body = document.querySelector("body");
        body.classList.toggle("game-over");
        title.innerText = "GAME OVER! Press a key to start again.";
        setTimeout(function(){
            body.classList.remove("game-over")
        }, 300);
        gameStarted = false;
        level = 1;
    }
}

for (let i = 0; i < numberBtns; i++) {
    document.querySelectorAll(".btn")[i].addEventListener("click", (e) => {
        if(gameStarted && userClickedPattern.length < gamePattern.length){
            makeSound(e.target.classList[1]);
            buttonAnimation(e.target.classList[1]);
            userChosenColor = e.target.classList[1];
            userClickedPattern.push(userChosenColor);
            checkAnswer(userClickedPattern.length-1);
            if(gameStarted && userClickedPattern.length >= gamePattern.length){
                checkAnswer(userClickedPattern.length-1);
            }
        }
    });
};

document.addEventListener("keypress", gameStart);
