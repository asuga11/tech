let score = JSON.parse(localStorage.getItem("score")) || {
    win: 0,
    loss: 0,
    tie: 0,
};

updateScoreElement(); // Хуудсыг дахин ачаалах үед оноог харуулах

document.querySelector(".js-haich-button").addEventListener("click", () => {
    playGame("haich");
});

document.querySelector(".js-chuluu-button").addEventListener("click", () => {
    playGame("chuluu");
});

document.querySelector(".js-daawuu-button").addEventListener("click", () => {
    playGame("daawuu");
});

function randomCom() {
    const randomNumber = Math.random();
    if (randomNumber < 1 / 3) {
        return "haich";
    } else if (randomNumber < 2 / 3) {
        return "chuluu";
    } else {
        return "daawuu";
    }
}

function playGame(playUser) {
    const computer = randomCom();
    let result = "";

    if (playUser === "haich") {
        if (computer === "haich") result = "tie";
        else if (computer === "chuluu") result = "loss";
        else result = "win";
    } else if (playUser === "chuluu") {
        if (computer === "haich") result = "win";
        else if (computer === "chuluu") result = "tie";
        else result = "loss";
    } else if (playUser === "daawuu") {
        if (computer === "haich") result = "loss";
        else if (computer === "chuluu") result = "win";
        else result = "tie";
    }

    if (result === "win") {
        score.win += 1;
    } else if (result === "loss") {
        score.loss += 1;
    } else if (result === "tie") {
        score.tie += 1;
    }

    localStorage.setItem("score", JSON.stringify(score));
    updateScoreElement();

    document.querySelector(".result").innerHTML = `Result: ${result}`;
    document.querySelector(".js-moves").innerHTML = `
        You 
        <img src="images/${playUser}-removebg-preview.png" class="move-icon"> 
        <img src="images/${computer}-removebg-preview.png" class="move-icon"> 
        Computer
    `;
}

function updateScoreElement() {
    document.querySelector(".js-score").innerHTML = `Win: ${score.win}, Loss: ${score.loss}, Tie: ${score.tie}`;
}

// Autoplay function
let isAutoPlaying = false;
let intervalId;

function autoplay() {
    if (!isAutoPlaying) {
        intervalId = setInterval(() => {
            const playerMove = randomCom();
            playGame(playerMove);
        }, 1000);
        isAutoPlaying = true;
    } else {
        clearInterval(intervalId);
        isAutoPlaying = false;
    }
}
