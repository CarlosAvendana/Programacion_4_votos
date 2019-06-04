-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema votosDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema votosDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `votosDB` DEFAULT CHARACTER SET utf8 ;
USE `votosDB` ;

-- -----------------------------------------------------
-- Table `votosDB`.`Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `votosDB`.`Usuario` ;

CREATE TABLE IF NOT EXISTS `votosDB`.`Usuario` (
  `Cedula` VARCHAR(30) NOT NULL,
  `Nombre` VARCHAR(45) NULL,
  `Apellido1` VARCHAR(45) NULL,
  `Apellido2` VARCHAR(45) NULL,
  `Contraseña` VARCHAR(32) NULL,
  `Voto` INT(1) NULL,
  PRIMARY KEY (`Cedula`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `votosDB`.`Partido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `votosDB`.`Partido` ;

CREATE TABLE IF NOT EXISTS `votosDB`.`Partido` (
  `IdPartido` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(20) NULL,
  `Siglas` VARCHAR(10) NULL,
  `Bandera` MEDIUMBLOB NULL,
  `FotoPostulante` MEDIUMBLOB NULL,
  `Observaciones` VARCHAR(500) NULL,
  `Votos` INT NULL,
  `Candidato` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`IdPartido`),
  INDEX `fk_Partido_usuario_idx` (`Candidato` ASC) VISIBLE,
  CONSTRAINT `fk_Partido_usuario`
    FOREIGN KEY (`Candidato`)
    REFERENCES `votosDB`.`Usuario` (`Cedula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `votosDB`.`Investigador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `votosDB`.`Investigador` ;

CREATE TABLE IF NOT EXISTS `votosDB`.`Investigador` (
  `Cedula` VARCHAR(30) NOT NULL,
  `Nombre` VARCHAR(45) NULL,
  `Apellido1` VARCHAR(45) NULL,
  `Apellido2` VARCHAR(45) NULL,
  `NombreUsuario` VARCHAR(45) NULL,
  `Contraseña` VARCHAR(45) NULL,
  `Observaciones` VARCHAR(500) NULL,
  PRIMARY KEY (`Cedula`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
