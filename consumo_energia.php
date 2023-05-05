<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Consumo de Energia</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
    <script src='main.js'></script>
    <style>
        .error {
            color: #FF0000;
            font-weight: bold;
        }
    </style>
</head>

<body>
    <?php
    // define variables and set to empty values
    $nameErr = $emailErr = $genderErr = $websiteErr = "";
    $name = $email = $gender = $comment = $website = "";

    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        if (empty($_POST["name"])) {
            $nameErr = "*Precisa escrever um nome";
        } else {
            $name = test_input($_POST["name"]);
            // check if name only contains letters and whitespace
            if (!preg_match("/^[a-zA-Z-' ]*$/", $name)) {
                $nameErr = "Apenas Letras são permitidas";
            }
        }

        if (empty($_POST["email"])) {
            $emailErr = "*Precisa digitar um Email";
        } else {
            $email = test_input($_POST["email"]);
            // check if e-mail address is well-formed
            if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
                $emailErr = "Formato de email inválido";
            }
        }

        if (empty($_POST["website"])) {
            $website = "";
        } else {
            $website = test_input($_POST["website"]);
            // check if URL address syntax is valid (this regular expression also allows dashes in the URL)
            if (!preg_match("/\b(?:(?:https?|ftp):\/\/|www\.)[-a-z0-9+&@#\/%?=~_|!:,.;]*[-a-z0-9+&@#\/%=~_|]/i", $website)) {
                $websiteErr = "URL inválida";
            }
        }

        if (empty($_POST["gender"])) {
            $genderErr = "*Preciso escolher uma opção de sexo";
        } else {
            $gender = test_input($_POST["gender"]);
        }
    }

    function test_input($data)
    {
        $data = trim($data);
        $data = stripslashes($data);
        $data = htmlspecialchars($data);
        return $data;
    }
    ?>

    <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
        <p>
            Nome:<br /> <input type="text" size="35" name="name" value="<?php echo $name; ?>"> <span class="error"><?php echo $nameErr; ?></span>
        </p>
        <p>
            Sexo:  <input type="radio" name="gender" hidden ><input type="radio" name="gender" <?php if (isset($gender) && $gender == "feminino") echo "checked"; ?> value="feminino">Feminino
            <input type="radio" name="gender" <?php if (isset($gender) && $gender == "masculino") echo "checked"; ?> value="masculino">Masculino
            <input type="radio" name="gender" <?php if (isset($gender) && $gender == "outro") echo "checked"; ?> value="outro">Outro
            <span class="error"> <?php echo $genderErr;?></span>
        </p>
        <p>
            CEP:<br /> <input type="text" size="35" name="cep">
        </p>
        <p>
            Bairro:<br /> <input type="text" size="35" name="bairro">
        </p>
        <p>
            CPF:<br /> <input type="text" size="35" name="cpf">
        </p>
        <p>
            Nascimento:<br /> <input type="date" size="35" name="nascimento">
        </p>
        <p>
            Data de Vencimento:<br /> <input type="date" size="35" name="data_vencimento">
        </p>
        <p>
            Unidade consumidora:<br /> <input type="text" size="35" name="unidade_consumidora">
        </p>
        <p>
            Kwh:<br /> <input type="text" size="35" name="kwh">
        </p>
        <p>
            E-mail:<br /> <input type="email" size="35" name="email" value="<?php echo $email; ?>"> <span class="error"> <?php echo $emailErr; ?></span>
        </p>
        <p>
            Site:<br /> <input type="text" size="35" name="website" value="<?php echo $website; ?>"> <span class="error"><?php echo $websiteErr; ?></span>
            <span class="error"><?php echo $websiteErr;?></span>
        </p>
        <p>
        <p>
            Valor Total:<br /> <input type="text" size="35" name="valor_total">
        </p>
        <input type="submit" name="BTEnvia" value="Enviar">
        <input type="reset" name="BTApaga" value="Apagar">
        </p>
    </form>
</body>

</html>