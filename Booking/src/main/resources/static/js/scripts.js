document.addEventListener('DOMContentLoaded', function () {

    console.log("DOM fully loaded and parsed");
});


function confirmDelete() {
    return confirm("Are you sure you want to delete this booking?");
}


document.querySelectorAll('a[href*="/bookings/delete"]').forEach(function(element) {
    element.addEventListener('click', confirmDelete);
});


