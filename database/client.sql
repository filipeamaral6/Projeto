CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(255) NOT NULL,
  `nif` int(11) NOT NULL,
  `client_cc` int(11) NOT NULL,
  `birthdate` date NOT NULL,
  `phone_number` bigint(20) DEFAULT NULL,
  `mobile_number` bigint(20) DEFAULT NULL,
  `address` varchar(255) NOT NULL,
  `zip_code` varchar(100) NOT NULL,
  `county` varchar(100) NOT NULL,
  `country` varchar(255) NOT NULL,
  `nationality` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL DEFAULT 'ACTIVE',
  `notification` varchar(100) NOT NULL DEFAULT 'TRUE',
  `transaction_password` varchar(255) NOT NULL,
  `created_at` date NOT NULL DEFAULT curdate(),
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `client_user_fk` (`user_id`),
  CONSTRAINT `client_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

