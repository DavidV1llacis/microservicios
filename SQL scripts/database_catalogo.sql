-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema catalogo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema catalogo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `catalogo` DEFAULT CHARACTER SET utf8 ;
USE `catalogo` ;

-- -----------------------------------------------------
-- Table `catalogo`.`items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `catalogo`.`items` (
  `codigo` VARCHAR(5) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `precio` DECIMAL(8,2) NOT NULL,
  `URL` VARCHAR(400) NOT NULL,
  `s` TINYINT NOT NULL,
  `m` TINYINT NOT NULL,
  `l` TINYINT NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;

CREATE USER 'servicio' IDENTIFIED BY '123123';

GRANT SELECT ON TABLE `catalogo`.* TO 'servicio';
GRANT SELECT, INSERT, TRIGGER ON TABLE `catalogo`.* TO 'servicio';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE `catalogo`.* TO 'servicio';

INSERT INTO `catalogo`.`items` (`codigo`, `nombre`, `precio`, `URL`, `s`, `m`, `l`) VALUES ('a1234', 'polo llano blanco', '5', 'https://oechsle.vteximg.com.br/arquivos/ids/9791509-1500-1500/1913543.jpg?v=637935167879930000', '1', '1', '1');
INSERT INTO `catalogo`.`items` (`codigo`, `nombre`, `precio`, `URL`, `s`, `m`, `l`) VALUES ('b1234', 'pantalon drill negro', '15', 'https://mister-mango.omni.la/ProductCatalog/Workspace.CWDQQL6GUIJMS/ProductCatalog.C2Y7ZLNDYIXQ6/1500x1500/C22CRXCHRJJPW.jpg', '1', '1', '1');
INSERT INTO `catalogo`.`items` (`codigo`, `nombre`, `precio`, `URL`, `s`, `m`, `l`) VALUES ('c1234', 'polera negra basica', '15', 'https://topitop.vteximg.com.br/arquivos/ids/221933-1000-1248/1687364_1.jpg?v=637719908117230000', '1', '1', '1');
INSERT INTO `catalogo`.`items` (`codigo`, `nombre`, `precio`, `URL`, `s`, `m`, `l`) VALUES ('d1234', 'polo estampado peru', '8', 'https://i.pinimg.com/originals/da/ea/f5/daeaf5580c34f863df2a838c512d7cfe.png', '1', '1', '1');


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
