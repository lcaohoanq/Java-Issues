document.addEventListener('DOMContentLoaded', function () {
    const addToCartButtonList = document.querySelectorAll("#add-to-cart");
    addToCartButtonList.forEach(function (button) {
        button.addEventListener('submit', function (event) {
            alert("Add successfully");
        });
    });
});