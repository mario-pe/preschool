CREATE PROCEDURE addZajęcia(IN przedmiot VARCHAR(45), IN godzina VARCHAR(45), IN rok VARCHAR(45))
  BEGIN
	INSERT INTO `przedszkole`.`zajecia_dodatkowe`
		(`przedmiot`, `godzina`, `rok_szkolny`) VALUES (przedmiot,godzina,rok);

END;
