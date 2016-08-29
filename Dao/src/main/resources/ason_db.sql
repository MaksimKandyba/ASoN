SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `ason_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `ason_db` ;

-- -----------------------------------------------------
-- Table `ason_db`.`animals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ason_db`.`animals` (
  `id` INT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `birthday` DATE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ason_db`.`messages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ason_db`.`messages` (
  `id` INT NULL AUTO_INCREMENT,
  `content` TEXT NOT NULL,
  `sending_off_time` DATETIME NOT NULL,
  `sender` INT NOT NULL,
  `addressee` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_sender_idx` (`sender` ASC),
  INDEX `fk_addressee_idx` (`addressee` ASC),
  CONSTRAINT `fk_sender`
    FOREIGN KEY (`sender`)
    REFERENCES `ason_db`.`animals` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_addressee`
    FOREIGN KEY (`addressee`)
    REFERENCES `ason_db`.`animals` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ason_db`.`posts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ason_db`.`posts` (
  `id` INT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `content` TEXT NOT NULL,
  `publication_time` DATETIME NOT NULL,
  `owner` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_posts_1_idx` (`owner` ASC),
  CONSTRAINT `fk_post_owner`
    FOREIGN KEY (`owner`)
    REFERENCES `ason_db`.`animals` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ason_db`.`friendship`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ason_db`.`friendship` (
  `friend_1` INT NOT NULL,
  `friend_2` INT NOT NULL,
  `beginning_time` DATETIME NOT NULL,
  PRIMARY KEY (`friend_1`, `friend_2`),
  INDEX `fk_animal_2_idx` (`friend_2` ASC),
  CONSTRAINT `fk_friend_1`
    FOREIGN KEY (`friend_1`)
    REFERENCES `ason_db`.`animals` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_friend_2`
    FOREIGN KEY (`friend_2`)
    REFERENCES `ason_db`.`animals` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ason_db`.`places`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ason_db`.`places` (
  `id` INT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `title_UNIQUE` (`title` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ason_db`.`likes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ason_db`.`likes` (
  `post` INT NOT NULL,
  `owner` INT NOT NULL,
  PRIMARY KEY (`post`, `owner`),
  INDEX `fk_animal_idx` (`owner` ASC),
  CONSTRAINT `fk_post`
    FOREIGN KEY (`post`)
    REFERENCES `ason_db`.`posts` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_like_owner`
    FOREIGN KEY (`owner`)
    REFERENCES `ason_db`.`animals` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ason_db`.`visiting`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ason_db`.`visiting` (
  `visitor` INT NOT NULL,
  `place` INT NOT NULL,
  PRIMARY KEY (`visitor`, `place`),
  INDEX `fk_place_idx` (`place` ASC),
  CONSTRAINT `fk_visitor`
    FOREIGN KEY (`visitor`)
    REFERENCES `ason_db`.`animals` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_place`
    FOREIGN KEY (`place`)
    REFERENCES `ason_db`.`places` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ason_db`.`hobbies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ason_db`.`hobbies` (
  `id` INT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `title_UNIQUE` (`title` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ason_db`.`leisure`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ason_db`.`leisure` (
  `holidaymaker` INT NOT NULL,
  `hobby` INT NOT NULL,
  PRIMARY KEY (`holidaymaker`, `hobby`),
  INDEX `fk_hobby_idx` (`hobby` ASC),
  CONSTRAINT `fk_holidaymaker`
    FOREIGN KEY (`holidaymaker`)
    REFERENCES `ason_db`.`animals` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_hobby`
    FOREIGN KEY (`hobby`)
    REFERENCES `ason_db`.`hobbies` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
