use mysite;

ALTER TABLE `mysite`.`news` ADD COLUMN `username` VARCHAR(45) DEFAULT NULL AFTER `publishtime`;