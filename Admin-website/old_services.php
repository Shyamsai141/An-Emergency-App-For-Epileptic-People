<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Services</title>
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Barlow+Semi+Condensed:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Goldman:wght@400;700&family=Kanit:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=League+Gothic&family=Madimi+One&family=Montserrat&family=Oswald:wght@200..700&family=Patrick+Hand&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto+Condensed:ital,wght@0,100..900;1,100..900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Saira+Condensed:wght@100;200;300;400;500;600;700;800;900&family=Timmana&display=swap"
      rel="stylesheet"
    />
    <style>
      .active {
        background-color: rgb(218, 153, 153);
        display: flex;
        justify-content: center;
        align-items: center;
        border-radius: 20px;
      }
      .service-history {
        background-color: rgb(192, 192, 214);
        display: flex;
        justify-content: center;
        align-items: center;
        padding: 150px;
        border-radius: 20px;
      }
      body {
        margin: 0;
      }
      .service {
        display: grid;
        grid-template-columns: 1fr 1fr;
        margin-left: 50px;
        margin-right: 50px;
        margin-top: 30px;
        column-gap: 20px;
      }
    </style>
  </head>
  <body>
    <h1 style="margin-top: 30px; margin-bottom: 0; margin-left: 50px;font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;">Services</h1>
    <div class="service">
      <div class="active">
        <h1
          style="
            font-family: Barlow Semi Condensed, sans-serif;
            font-weight: 500;
            font-style: normal;
            color: white;
          "
        >
          Active
        </h1>
      </div>
      <div class="service-history">
        <h1
          style="
            font-family: Barlow Semi Condensed, sans-serif;
            font-weight: 500;
            font-style: normal;
            color: white;
          "
        >
          History
        </h1>
      </div>
    </div>
  </body>
</html>
