import { updateGround, setupGround } from "./ground.js";
import {
  updateBobcat,
  setupBobcat,
  getBobcatRect,
  setBobcatLose,
} from "./bobcat.js";
import {
  updateClocktower,
  setupClocktower,
  getClocktowerReacts,
} from "./clocktower.js";

const SPEED_SCALE_INCREASE = 0.00001;

const OVERALL_WIDTH = 600;
const OVERALL_HEIGHT = 300;

const overallElem = document.querySelector("[data-overall]");

const scoreElem = document.querySelector("[data-score]");
const startScreenElem = document.querySelector("[data-start-screen]");
const logoElem = document.querySelector("[data-Logo]");

setOverallScale();
window.addEventListener("resize", setOverallScale);

document.addEventListener("keydown", handleStart, { once: true });

let lastTime;
let speedScale;
let score;
function update(time) {
  if (lastTime == null) {
    lastTime = time;
    window.requestAnimationFrame(update);
    return;
  }

  const delta = time - lastTime;

  updateGround(delta, speedScale);
  updateBobcat(delta, speedScale);
  updateClocktower(delta, speedScale);
  updateSpeedScale(delta);
  updateScore(delta);
  if (checkLose()) return handleLose();

  lastTime = time;
  window.requestAnimationFrame(update);
}

function checkLose() {
  const bobcatRect = getBobcatRect();
  return getClocktowerReacts().some((rect) => isCollision(rect, bobcatRect));
}

function isCollision(rect1, rect2) {
  return (
    rect1.left < rect2.right &&
    rect1.top < rect2.bottom &&
    rect1.right > rect2.left &&
    rect1.bottom > rect2.top
  );
}

function updateSpeedScale(delta) {
  speedScale += delta * SPEED_SCALE_INCREASE;
}

function updateScore(delta) {
  score += delta * 0.01;
  scoreElem.textContent = Math.floor(score);
}

function handleStart() {
  lastTime = null;
  speedScale = 1;
  score = 0;
  setupGround();
  setupBobcat();
  setupClocktower();
  startScreenElem.classList.add("hide");
  logoElem.classList.add("hide");
  window.requestAnimationFrame(update);
  console.clear();
  console.log(
    "%cAndrew Litz - Capstone Project - 2023",
    "background: #222; color: gray"
  );
  console.log("%c--- GAME STARTED ---", "background: #222; color: #32CD32");
}

function handleLose() {
  setBobcatLose();
  setTimeout(() => {
    document.addEventListener("keydown", handleStart, { once: true });
    startScreenElem.classList.remove("hide");
  }, 100);
  logoElem.classList.remove("hide");
  console.log("%cFinal Score: " + score, "background: #222; color: #00FFFF");
  console.log(
    "%cFinal Speed " + speedScale,
    "background: #222; color: #FF69B4"
  );
  console.log("%cGAME ENDED (COLLISION) ", "background: #222; color: red");
}

function setOverallScale() {
  let overallScale;
  if (window.innerWidth / window.innerHeight < OVERALL_WIDTH / OVERALL_WIDTH) {
    overallScale = window.innerWidth / OVERALL_WIDTH;
  } else {
    overallScale = window.innerHeight / OVERALL_WIDTH;
  }

  overallElem.style.width = `${OVERALL_WIDTH * overallScale}px`;
  overallElem.style.height = `${OVERALL_HEIGHT * overallScale}px`;
}
