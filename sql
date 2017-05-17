CREATE SCHEMA IF NOT EXISTS `Hospital` DEFAULT CHARACTER SET latin1 ;
USE `Hospital` ;

-- -----------------------------------------------------
-- Table `Hospital`.`Consultation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospital`.`Consultation` (
  `idConsultation` INT(11) NOT NULL AUTO_INCREMENT,
  `idDoctor` INT(11) NOT NULL,
  `idPatient` INT(11) NULL DEFAULT NULL,
  `start` INT(11) NULL DEFAULT NULL,
  `done` TINYINT(4) NULL DEFAULT '0',
  `observations` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idConsultation`),
  UNIQUE INDEX `idCosultation_UNIQUE` (`idConsultation` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 66
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `Hospital`.`Doctor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospital`.`Doctor` (
  `idDoctor` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDoctor`),
  UNIQUE INDEX `idDoctor_UNIQUE` (`idDoctor` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `Hospital`.`Patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospital`.`Patient` (
  `idPatient` INT(11) NOT NULL AUTO_INCREMENT,
  `identityCard` VARCHAR(8) NOT NULL,
  `CNP` VARCHAR(13) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPatient`),
  UNIQUE INDEX `idPatient_UNIQUE` (`idPatient` ASC),
  UNIQUE INDEX `identityCard_UNIQUE` (`identityCard` ASC),
  UNIQUE INDEX `CNP_UNIQUE` (`CNP` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `Hospital`.`Secretary`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospital`.`Secretary` (
  `idSecretary` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idSecretary`),
  UNIQUE INDEX `idSecretary_UNIQUE` (`idSecretary` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `Hospital`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospital`.`User` (
  `idUser` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `enabled` TINYINT(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idUser`),
  UNIQUE INDEX `idUser_UNIQUE` (`idUser` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 31
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `Hospital`.`User_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospital`.`User_role` (
  `idUser_role` INT(11) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUser_role`),
  UNIQUE INDEX `idUser_role_UNIQUE` (`idUser_role` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


