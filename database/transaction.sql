CREATE TABLE `transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` double NOT NULL,
  `account_iban` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp(),
  `user_id` int(11) DEFAULT NULL,
  `type` varchar(100) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `account_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `transaction_account_fk` (`account_iban`),
  KEY `transaction_user_fk` (`user_id`),
  KEY `transaction_fk` (`account_id`),
  CONSTRAINT `transaction_account_fk` FOREIGN KEY (`account_iban`) REFERENCES `account` (`iban`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `transaction_fk` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `transaction_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
