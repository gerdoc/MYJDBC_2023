-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Prueba
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Prueba
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Prueba` DEFAULT CHARACTER SET utf8 ;
USE `Prueba` ;

-- -----------------------------------------------------
-- Table `Prueba`.`ROL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Prueba`.`ROL` (
  `ROL` VARCHAR(30) NOT NULL,
  `DESCRIPCION` VARCHAR(100) NULL,
  PRIMARY KEY (`ROL`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
