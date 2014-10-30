<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Ops Tempo Calendar View</title>


    <link rel="stylesheet" type="text/css" href="resources/extjs/ext-theme-gray-all.css">

    <script type="text/javascript" src="resources/extjs/ext-all-debug.js"></script>
    <script type="text/javascript" src="resources/extjs/ext-theme-gray.js"></script>


    <link rel="stylesheet" type="text/css" href="resources/css/calendar.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/examples.css"/>


    <script type="text/javascript">
        //Enable dynamic loading of classes from the ext framework
        Ext.Loader.setConfig({
            enabled: true,
            paths: {
                'Ext.calendar': 'app'
            }
        });
        Ext.require([
            //'Ext.diag.layout.Context',
            //'Ext.diag.layout.ContextItem',
            'Ext.calendar.App'
        ]);
        Ext.onReady(function () {
            // launch the app:
            Ext.create('Ext.calendar.App');

            // update the header logo date:
            document.getElementById('logo-body').innerHTML = new Date().getDate();
        });
    </script>

</head>
<body>
<div style="display:none;">
    <div id="app-header-content">
        <div id="app-logo">
            <div class="logo-top">&nbsp;</div>
            <div id="logo-body">&nbsp;</div>
            <div class="logo-bottom">&nbsp;</div>
        </div>
        <h1>Ops Tempo Calendar View</h1>
        <span id="app-msg" class="x-hidden"></span>
    </div>
</div>
</body>
</html>