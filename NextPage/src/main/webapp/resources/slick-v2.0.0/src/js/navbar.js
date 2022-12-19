// import utils from "./utils";
/*-----------------------------------------------
|   Top navigation opacity on scroll
-----------------------------------------------*/
const navbarInit = () => {
  const navbar = document.querySelector("[data-navbar-dark-on-scroll]");
  const navBurger = document.querySelector("[data-bs-toggle]");

  if (navbar) {
    const windowHeight = window.innerHeight;
    const handleAlpha = () => {
      const scrollTop = window.pageYOffset;
      let alpha = (scrollTop / windowHeight) * 2;
      alpha >= 1 && (alpha = 1);
      navbar.style.backgroundColor = `rgba(0, 0, 0, ${alpha})`;
    };
    handleAlpha();
    document.addEventListener("scroll", () => handleAlpha());

    // Top navigation background toggle on mobile
    navbar.addEventListener("show.bs.collapse", (e) => {
      e.currentTarget.classList.toggle("bg-dark");
    });
    navbar.addEventListener("hide.bs.collapse", (e) => {
      e.currentTarget.classList.toggle("bg-dark");
    });
  }
  if (navBurger) {
    navBurger.addEventListener("click", () => {
      navBurger.classList.toggle("is-active");
    });
  }
};
export default navbarInit;
