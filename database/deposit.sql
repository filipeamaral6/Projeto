CREATE TABLE `deposit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `transaction_id` int(11) NOT NULL,
  `depositer_name` varchar(255) NOT NULL,
  `depositer_cc_number` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `deposit_employee_fk` (`employee_id`),
  KEY `deposit_transaction_fk` (`transaction_id`),
  CONSTRAINT `deposit_employee_fk` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `deposit_transaction_fk` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
