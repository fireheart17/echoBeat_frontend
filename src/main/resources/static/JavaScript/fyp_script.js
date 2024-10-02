typography_ptr=0;
const hero_typography=()=>{
    const text="Hello Dev! Keep Vibing to your favourite music.";
    hero_text=document.getElementById("hero-text");
    if(hero_text && typography_ptr<text.length){
        hero_text.innerHTML+=text[typography_ptr];
        typography_ptr++;
    }else{
        clearInterval(typography_interval);
    }
}
typography_interval=setInterval(hero_typography,60);

const container = document.getElementById('subCardsContainer');

let isDown = false;
let startX;
let scrollLeft;

container.addEventListener('mousedown', (e) => {
    isDown = true;
    container.classList.add('active');
    startX = e.pageX - container.offsetLeft;
    scrollLeft = container.scrollLeft;
});

container.addEventListener('mouseleave', () => {
    isDown = false;
    container.classList.remove('active');
});

container.addEventListener('mouseup', () => {
    isDown = false;
    container.classList.remove('active');
});

container.addEventListener('mousemove', (e) => {
    if (!isDown) return;
    e.preventDefault();
    const x = e.pageX - container.offsetLeft;
    const walk = (x - startX) * 2; // The multiplier can be adjusted for scroll speed
    container.scrollLeft = scrollLeft - walk;
});

// Touch events for mobile
let startXTouch, scrollLeftTouch;

container.addEventListener('touchstart', (e) => {
    startXTouch = e.touches[0].pageX - container.offsetLeft;
    scrollLeftTouch = container.scrollLeft;
});

container.addEventListener('touchmove', (e) => {
    const x = e.touches[0].pageX - container.offsetLeft;
    const walk = (x - startXTouch) * 2; // Similar multiplier as in the mouse event
    container.scrollLeft = scrollLeftTouch - walk;
});

// Existing JavaScript code...

// Sliding Menu Functionality
const hamburgerMenu = document.getElementById('hamburgerMenu');
const slidingMenu = document.getElementById('slidingMenu');
const closeBtn = document.getElementById('closeBtn');

hamburgerMenu.addEventListener('click', () => {
    slidingMenu.classList.add('open');
    document.body.classList.add('menu-open');  // Prevent scrolling of body
});

closeBtn.addEventListener('click', () => {
    slidingMenu.classList.remove('open');
    document.body.classList.remove('menu-open');
});

// Close the menu if clicking outside
window.addEventListener('click', (e) => {
    if (e.target !== slidingMenu && e.target !== hamburgerMenu && !slidingMenu.contains(e.target)) {
        slidingMenu.classList.remove('open');
        document.body.classList.remove('menu-open');
    }
});
