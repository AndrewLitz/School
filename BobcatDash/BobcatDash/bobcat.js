import {
  incrementCustomProperty,
  setCustomProperty,
  getCustomProperty,
} from "./updateCustomProperty.js";

const bobcatElem = document.querySelector("[data-bobcat]");
const JUMP_SPEED = 0.45;
const GRAVITY = 0.0014;
const BOBCAT_FRAME_COUNT = 2;
const FRAME_TIME = 100;

let isJumping;
let bobcatFrame;
let currentFrameTime;
let yVelocity;
export function setupBobcat() {
  isJumping = false;
  bobcatFrame = 0;
  currentFrameTime = 0;
  yVelocity = 0;
  setCustomProperty(bobcatElem, "--bottom", 0);
  document.removeEventListener("keydown", onJump);
  document.addEventListener("keydown", onJump);
}

export function updateBobcat(delta, speedScale) {
  handleRun(delta, speedScale);
  handleJump(delta);
}

export function getBobcatRect() {
  return bobcatElem.getBoundingClientRect();
}

export function setBobcatLose() {
  bobcatElem.src = "images/bobcat-lose.png";
}

function handleRun(delta, speedScale) {
  if (isJumping) {
    bobcatElem.src = `images/bobcat-stationary.png`;
    return;
  }

  if (currentFrameTime >= FRAME_TIME) {
    bobcatFrame = (bobcatFrame + 1) % BOBCAT_FRAME_COUNT;
    bobcatElem.src = `images/bobcat-run-${bobcatFrame}.png`;
    currentFrameTime -= FRAME_TIME;
  }
  currentFrameTime += delta * speedScale;
}

function handleJump(delta) {
  if (!isJumping) return;

  incrementCustomProperty(bobcatElem, "--bottom", yVelocity * delta);

  if (getCustomProperty(bobcatElem, "--bottom") <= 0) {
    setCustomProperty(bobcatElem, "--bottom", 0);
    isJumping = false;
  }

  yVelocity -= GRAVITY * delta;
}

function onJump(e) {
  if (e.code !== "Space" || isJumping) return;

  yVelocity = JUMP_SPEED;
  isJumping = true;
}
