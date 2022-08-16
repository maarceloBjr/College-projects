let count = 0;
let countEl = document.getElementById("count-el");
let saveEl = document.getElementById("save-el");
let totalEntries = "";

function increment(){
    count++;
    countEl.innerText = count;
}

function save(){
    strEntries = count + " - ";
    saveEl.textContent += strEntries;
    countEl.innerText = 0;
    count = 0;
}

//https://www.youtube.com/watch?v=jS4aFq5-91M