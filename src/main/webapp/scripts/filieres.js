function confirmDelete() {
    if (confirm("Are you sure you want to delete this item?")) {
        // Send delete request to server with the corresponding id
        var itemId = // get the item id
        $.ajax({
            type: "DELETE",
            url: "/items/" + itemId,
            success: function(response) {
                // Do something on success, such as refresh the page or remove the item from the page
            },
            error: function(error) {
                console.log(error);
            }
        });
    }
}