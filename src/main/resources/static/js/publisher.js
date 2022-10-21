$(document).ready(function () {
    $('.table .actDeactBtn').on('click', function (event) {
        event.preventDefault();
        const href = $(this).attr('href');
        const post = href.split('?');
        const text = $(this).text(); //return New or Edit

        var alertMessage = "";
        var alertBtn = "";
        var alertlabel = "";
        if (text === 'Activate') {
            alertMessage = "Are you sure you want to activate this Publisher?";
            alertBtn = "Activate";
            alertlabel = "Activate Publisher";
        }
        else{
            alertMessage = "Are you sure you want to deactivate this Publisher?";
            alertBtn = "Deactivate";
            alertlabel = "Deactivate Publisher";
        }

        $('#actDeactivateModel #alertMessage').text(alertMessage);
        $('#actDeactivateModel #actDeactivateRef').text(alertBtn);
        $('#actDeactivateModel #actDeactivateModelLabel').text(alertlabel);
        $('#actDeactivateModel').modal();

        $.post(post[0], post[1], function(i) {
        });
    });

    $('.table .delBtn').on('click', function (event) {
        event.preventDefault();
        const href = $(this).attr('href');
        $('#myModal #delRef').attr('href', href);
        $('#myModal').modal();
    });
});