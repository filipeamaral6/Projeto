CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,
  `iban` varchar(255) NOT NULL,
  `account_number` bigint(20) NOT NULL,
  `balance` double NOT NULL DEFAULT 500,
  `interest` double NOT NULL DEFAULT 0.02,
  `status` varchar(100) NOT NULL DEFAULT 'ACTIVE',
  `created_at` date NOT NULL DEFAULT curdate(),
  `employee_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_un_iban` (`iban`),
  UNIQUE KEY `account_un_acc_number` (`account_number`),
  KEY `account_employee_fk` (`employee_id`),
  CONSTRAINT `account_employee_fk` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
