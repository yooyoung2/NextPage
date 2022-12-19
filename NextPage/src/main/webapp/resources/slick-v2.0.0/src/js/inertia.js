import utils from "./utils";

function inertiaInit() {
  const Selector = {
    DATA_INERTIA: "[data-inertia]",
  };
  const DATA_KEY = {
    INERTIA: "inertia",
  };
  const Events = {
    SCROLL: "scroll",
    RESIZE: "resize",
  };

  const inertiaEls = document.querySelectorAll(Selector.DATA_INERTIA);

  inertiaEls.forEach((el) => {
    const rect = el.getBoundingClientRect();
    const options = utils.getData(el, DATA_KEY.INERTIA);
    const offsetTop = rect.top >= 0 ? rect.top : 0;
    const winHeight = window.innerHeight;
    let currentPosition = window.pageYOffset;
    let y = 0;
    let previousPosition = 0;
    const initialTranslate = ((offsetTop - currentPosition) * 100) / winHeight;

    const controller = {
      weight: 1,
      y: 0,
      duration: 2,
      ease: "Expo.easeOut",
      delay: 0,
    };

    Object.assign(controller, options);

    // eslint-disable-next-line no-param-reassign
    el.style.transform = `translateY(${initialTranslate}px);`;

    const inertiaEffect = () => {
      currentPosition = window.pageYOffset;
      y = (controller.weight * (offsetTop - currentPosition) * 100) / winHeight;

      currentPosition === previousPosition ||
        window.gsap.to(el, {
          duration: controller.duration,
          y,
          ease: controller.ease,
        });

      previousPosition = currentPosition;
    };

    window.addEventListener(Events.SCROLL, inertiaEffect);
    window.addEventListener(Events.RESIZE, inertiaEffect);
  });
}

export default inertiaInit;
