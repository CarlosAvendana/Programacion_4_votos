-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema votosdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema votosdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `votosdb` DEFAULT CHARACTER SET utf8 ;
USE `votosdb` ;

-- -----------------------------------------------------
-- Table `votosdb`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `votosdb`.`usuario` ;

CREATE TABLE IF NOT EXISTS `votosdb`.`usuario` (
  `Cedula` VARCHAR(30) NOT NULL,
  `NombreCompleto` VARCHAR(100) NULL,
  `Contraseña` VARCHAR(32) NULL,
  PRIMARY KEY (`Cedula`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `votosdb`.`Partido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `votosdb`.`Partido` ;

CREATE TABLE IF NOT EXISTS `votosdb`.`Partido` (
  `IdPartido` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(20) NULL,
  `Siglas` VARCHAR(10) NULL,
  `Bandera` MEDIUMBLOB NULL,
  `FotoPostulante` MEDIUMBLOB NULL,
  `usuario_Cedula` VARCHAR(30) NOT NULL,
  `Observaciones` VARCHAR(55) NULL,
  `Votos` INT NULL,
  PRIMARY KEY (`IdPartido`),
  INDEX `fk_Partido_usuario_idx` (`usuario_Cedula` ASC) VISIBLE,
  CONSTRAINT `fk_Partido_usuario`
    FOREIGN KEY (`usuario_Cedula`)
    REFERENCES `votosdb`.`usuario` (`Cedula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `votosdb`.`Investigador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `votsdb`.`Investigador` ;

CREATE TABLE IF NOT EXISTS `votosdb`.`Investigador` (
  `Cedula` VARCHAR(30) NOT NULL,
  `NombreCompleto` VARCHAR(100) NULL,
  `Contraseña` VARCHAR(45) NULL,
  `Observaciones` VARCHAR(45) NULL,
  `NombreUsuario` VARCHAR(45) NULL,
  PRIMARY KEY (`Cedula`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
