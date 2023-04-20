import {
  setCustomProperty,
  incrementCustomProperty,
  getCustomProperty,
} from "./updateCustomProperty.js";

const SPEED = 0.05;
var CLOCKTOWERCOUNT = 0;
const CLOCKTOWER_INTERVAL_MIN = 500;
const CLOCKTOWER_INTERVAL_MAX = 2000;
const overallElem = document.querySelector("[data-overall]");

let nextClocktowerTime;
export function setupClocktower() {
  nextClocktowerTime = CLOCKTOWER_INTERVAL_MIN;
  document.querySelectorAll("[data-clocktower]").forEach((clocktower) => {
    clocktower.remove();
  });
}

export function updateClocktower(delta, speedScale) {
  document.querySelectorAll("[data-clocktower]").forEach((clocktower) => {
    incrementCustomProperty(
      clocktower,
      "--left",
      delta * speedScale * SPEED * -1
    );
    if (getCustomProperty(clocktower, "--left") <= -200) {
      clocktower.remove();
    }
  });

  if (nextClocktowerTime <= 0) {
    createClocktower();
    nextClocktowerTime =
      randomNumberBetween(CLOCKTOWER_INTERVAL_MIN, CLOCKTOWER_INTERVAL_MAX) /
      speedScale;
  }
  nextClocktowerTime -= delta / 2;
}

export function getClocktowerReacts() {
  return [...document.querySelectorAll("[data-clocktower]")].map(
    (clocktower) => {
      return clocktower.getBoundingClientRect();
    }
  );
}

function createClocktower() {
  const clocktower = document.createElement("img");
  clocktower.dataset.clocktower = true;
  clocktower.src = "images/clocktower.png";
  clocktower.classList.add("clocktower");
  setCustomProperty(clocktower, "--left", 100);
  overallElem.append(clocktower);
  CLOCKTOWERCOUNT++;
  console.log("%cCreated New Clocktower ", "background: #222; color: #FFFF00");
}

function randomNumberBetween(min, max) {
  return Math.floor(Math.random() * (max - min + 1) + min);
}
