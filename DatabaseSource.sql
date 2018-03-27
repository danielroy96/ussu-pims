-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: pims
-- ------------------------------------------------------
-- Server version	5.7.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `item_details`
--

DROP TABLE IF EXISTS `item_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL,
  `start_datetime` datetime NOT NULL,
  `end_datetime` datetime DEFAULT NULL,
  `status_control` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `last_changed_by_user_id` int(11) DEFAULT NULL,
  `barcode` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `item_type` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `barcode_UNIQUE` (`barcode`),
  KEY `item_detail_fk1_idx` (`item_id`),
  KEY `item_detail_fk2_idx` (`status_control`),
  KEY `item_detail_fk3_idx` (`status`),
  KEY `item_detail_fk4_idx` (`last_changed_by_user_id`),
  KEY `item_detail_fk5_idx` (`item_type`),
  CONSTRAINT `item_detail_fk1` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `item_detail_fk2` FOREIGN KEY (`status_control`) REFERENCES `status_control` (`status_control`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `item_detail_fk3` FOREIGN KEY (`status`) REFERENCES `item_statuses` (`mnem`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `item_detail_fk4` FOREIGN KEY (`last_changed_by_user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `item_detail_fk5` FOREIGN KEY (`item_type`) REFERENCES `item_types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3538 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `item_details_current`
--

DROP TABLE IF EXISTS `item_details_current`;
/*!50001 DROP VIEW IF EXISTS `item_details_current`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `item_details_current` AS SELECT 
 1 AS `id`,
 1 AS `item_id`,
 1 AS `start_datetime`,
 1 AS `end_datetime`,
 1 AS `status_control`,
 1 AS `status`,
 1 AS `last_changed_by_user_id`,
 1 AS `barcode`,
 1 AS `description`,
 1 AS `item_type`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `item_details_current_extant`
--

DROP TABLE IF EXISTS `item_details_current_extant`;
/*!50001 DROP VIEW IF EXISTS `item_details_current_extant`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `item_details_current_extant` AS SELECT 
 1 AS `id`,
 1 AS `item_id`,
 1 AS `start_datetime`,
 1 AS `end_datetime`,
 1 AS `status_control`,
 1 AS `status`,
 1 AS `last_changed_by_user_id`,
 1 AS `barcode`,
 1 AS `description`,
 1 AS `item_type`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `item_events`
--

DROP TABLE IF EXISTS `item_events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_events` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mnem` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `display_text` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `item_id` int(11) DEFAULT NULL,
  `event_datetime` datetime NOT NULL,
  `event_user_id` int(11) NOT NULL,
  `test_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `item_event_fk1_idx` (`item_id`),
  KEY `item_event_fk2_idx` (`event_user_id`),
  KEY `item_event_fk3_idx` (`test_id`),
  CONSTRAINT `item_event_fk1` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `item_event_fk2` FOREIGN KEY (`event_user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `item_event_fk3` FOREIGN KEY (`test_id`) REFERENCES `tests` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `item_maintenance_logs`
--

DROP TABLE IF EXISTS `item_maintenance_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_maintenance_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL,
  `description` longtext COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `item_maintenance_log_fk1_idx` (`item_id`),
  CONSTRAINT `item_maintenance_log_fk1` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `item_on_job`
--

DROP TABLE IF EXISTS `item_on_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_on_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL,
  `job_id` int(11) NOT NULL,
  `status` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `added_datetime` datetime NOT NULL,
  `returned_datetime` datetime DEFAULT NULL,
  `removed_datetime` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `item_on_job_fk1_idx` (`item_id`),
  KEY `item_on_job_fk2_idx` (`job_id`),
  CONSTRAINT `item_on_job_fk1` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `item_on_job_fk2` FOREIGN KEY (`job_id`) REFERENCES `jobs` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `item_statuses`
--

DROP TABLE IF EXISTS `item_statuses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_statuses` (
  `mnem` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `display_text` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`mnem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `item_types`
--

DROP TABLE IF EXISTS `item_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `value` decimal(10,0) DEFAULT NULL,
  `weight` decimal(10,0) DEFAULT NULL,
  `requires_pat` tinyint(1) NOT NULL,
  `pat_interval_months` int(11) DEFAULT NULL,
  `created_by_user_id` int(11) NOT NULL,
  `last_changed_by_user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `item_type_fk1_idx` (`created_by_user_id`),
  KEY `item_type_fk2_idx` (`last_changed_by_user_id`),
  CONSTRAINT `item_type_fk1` FOREIGN KEY (`created_by_user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `item_type_fk2` FOREIGN KEY (`last_changed_by_user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1030 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_by_user_id` int(11) NOT NULL,
  `created_datetime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `item_fk1_idx` (`created_by_user_id`),
  CONSTRAINT `item_fk1` FOREIGN KEY (`created_by_user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3539 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `jobs`
--

DROP TABLE IF EXISTS `jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `client_name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `job_start_datetime` datetime DEFAULT NULL,
  `job_end_datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `status_control`
--

DROP TABLE IF EXISTS `status_control`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status_control` (
  `status_control` varchar(1) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'C',
  PRIMARY KEY (`status_control`),
  UNIQUE KEY `status_control_UNIQUE` (`status_control`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tests`
--

DROP TABLE IF EXISTS `tests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tests` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL,
  `test_datetime` datetime NOT NULL,
  `test_user` int(11) DEFAULT NULL,
  `earth_resistance_ohms` decimal(10,5) DEFAULT NULL,
  `insulation_resistance_mohms` decimal(10,5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `test_fk1_idx` (`item_id`),
  KEY `test_fk2_idx` (`test_user`),
  CONSTRAINT `test_fk1` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `test_fk2` FOREIGN KEY (`test_user`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_details`
--

DROP TABLE IF EXISTS `user_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `start_datetime` datetime NOT NULL,
  `end_datetime` datetime DEFAULT NULL,
  `status_control` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `forename` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `surname` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `title` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `user_role` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `user_type` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `last_changed_by_user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_details_fk1_idx` (`user_id`),
  KEY `user_details_fk2_idx` (`user_type`),
  KEY `user_details_fk3_idx` (`status`),
  KEY `user_details_fk4_idx` (`user_role`),
  KEY `user_details_fk5_idx` (`last_changed_by_user_id`),
  KEY `user_details_status_control_idx` (`status_control`),
  CONSTRAINT `user_details_fk1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_details_fk2` FOREIGN KEY (`user_type`) REFERENCES `user_types` (`type_mnem`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_details_fk3` FOREIGN KEY (`status`) REFERENCES `user_statuses` (`status_mnem`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_details_fk4` FOREIGN KEY (`user_role`) REFERENCES `user_roles` (`role_mnem`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_details_fk5` FOREIGN KEY (`last_changed_by_user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_details_status_control` FOREIGN KEY (`status_control`) REFERENCES `status_control` (`status_control`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=167 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `user_details_current`
--

DROP TABLE IF EXISTS `user_details_current`;
/*!50001 DROP VIEW IF EXISTS `user_details_current`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `user_details_current` AS SELECT 
 1 AS `id`,
 1 AS `user_id`,
 1 AS `start_datetime`,
 1 AS `end_datetime`,
 1 AS `status_control`,
 1 AS `status`,
 1 AS `username`,
 1 AS `password`,
 1 AS `forename`,
 1 AS `surname`,
 1 AS `title`,
 1 AS `user_role`,
 1 AS `user_type`,
 1 AS `last_changed_by_user_id`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `user_details_current_extant`
--

DROP TABLE IF EXISTS `user_details_current_extant`;
/*!50001 DROP VIEW IF EXISTS `user_details_current_extant`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `user_details_current_extant` AS SELECT 
 1 AS `id`,
 1 AS `user_id`,
 1 AS `start_datetime`,
 1 AS `end_datetime`,
 1 AS `status_control`,
 1 AS `status`,
 1 AS `username`,
 1 AS `password`,
 1 AS `forename`,
 1 AS `surname`,
 1 AS `title`,
 1 AS `user_role`,
 1 AS `user_type`,
 1 AS `last_changed_by_user_id`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `role_mnem` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `display_text` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`role_mnem`),
  UNIQUE KEY `role_mnem_UNIQUE` (`role_mnem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_statuses`
--

DROP TABLE IF EXISTS `user_statuses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_statuses` (
  `status_mnem` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `display_text` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`status_mnem`),
  UNIQUE KEY `status_mnem_UNIQUE` (`status_mnem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_types`
--

DROP TABLE IF EXISTS `user_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_types` (
  `type_mnem` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `display_text` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`type_mnem`),
  UNIQUE KEY `type_mnem_UNIQUE` (`type_mnem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_by_user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `users_fk1_idx` (`created_by_user_id`),
  CONSTRAINT `users_fk1` FOREIGN KEY (`created_by_user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Final view structure for view `item_details_current`
--

/*!50001 DROP VIEW IF EXISTS `item_details_current`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `item_details_current` AS select `id`.`id` AS `id`,`id`.`item_id` AS `item_id`,`id`.`start_datetime` AS `start_datetime`,`id`.`end_datetime` AS `end_datetime`,`id`.`status_control` AS `status_control`,`id`.`status` AS `status`,`id`.`last_changed_by_user_id` AS `last_changed_by_user_id`,`id`.`barcode` AS `barcode`,`id`.`description` AS `description`,`id`.`item_type` AS `item_type` from `item_details` `id` where (`id`.`status_control` = 'C') order by `id`.`item_id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `item_details_current_extant`
--

/*!50001 DROP VIEW IF EXISTS `item_details_current_extant`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `item_details_current_extant` AS select `item_details_current`.`id` AS `id`,`item_details_current`.`item_id` AS `item_id`,`item_details_current`.`start_datetime` AS `start_datetime`,`item_details_current`.`end_datetime` AS `end_datetime`,`item_details_current`.`status_control` AS `status_control`,`item_details_current`.`status` AS `status`,`item_details_current`.`last_changed_by_user_id` AS `last_changed_by_user_id`,`item_details_current`.`barcode` AS `barcode`,`item_details_current`.`description` AS `description`,`item_details_current`.`item_type` AS `item_type` from `item_details_current` where (`item_details_current`.`status` = 'CURRENT') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `user_details_current`
--

/*!50001 DROP VIEW IF EXISTS `user_details_current`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `user_details_current` AS select `ud`.`id` AS `id`,`ud`.`user_id` AS `user_id`,`ud`.`start_datetime` AS `start_datetime`,`ud`.`end_datetime` AS `end_datetime`,`ud`.`status_control` AS `status_control`,`ud`.`status` AS `status`,`ud`.`username` AS `username`,`ud`.`password` AS `password`,`ud`.`forename` AS `forename`,`ud`.`surname` AS `surname`,`ud`.`title` AS `title`,`ud`.`user_role` AS `user_role`,`ud`.`user_type` AS `user_type`,`ud`.`last_changed_by_user_id` AS `last_changed_by_user_id` from `user_details` `ud` where (`ud`.`status_control` = 'C') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `user_details_current_extant`
--

/*!50001 DROP VIEW IF EXISTS `user_details_current_extant`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `user_details_current_extant` AS select `udc`.`id` AS `id`,`udc`.`user_id` AS `user_id`,`udc`.`start_datetime` AS `start_datetime`,`udc`.`end_datetime` AS `end_datetime`,`udc`.`status_control` AS `status_control`,`udc`.`status` AS `status`,`udc`.`username` AS `username`,`udc`.`password` AS `password`,`udc`.`forename` AS `forename`,`udc`.`surname` AS `surname`,`udc`.`title` AS `title`,`udc`.`user_role` AS `user_role`,`udc`.`user_type` AS `user_type`,`udc`.`last_changed_by_user_id` AS `last_changed_by_user_id` from `user_details_current` `udc` where (`udc`.`status` = 'CURRENT') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-27 22:45:03
