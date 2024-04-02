INSERT INTO users (EMAIL, PASSWORD_HASH, ROLE, NAME, AGE)
VALUES
  ('user1@example.com', '$2a$12$gCaYxAfYGm70xx77u2U1ce8BIDRb0Hg3jyT9At40rJh/VkJ6tRxzO', 'USER', 'User One', 30),
  ('user2@example.com', '$2a$12$loaoN701pydYBB6yM2vraeMRKwl2xLGjSJp/tpButQjzjFJnXq4Rq', 'USER', 'User Two', 25),
  ('user3@example.com', '$2a$12$gMURxQ4FcSTtZaRsz6hYf.6xLWogU91Ru1tXmbQT7HCL9mmdE62C6', 'USER', 'User Three', 28),
  ('user4@example.com', '$2a$12$58UmxfuRMOANlkyso1j5XOnLHxFCIA5iIzqhhttgiEGyHrne3EqDS', 'USER', 'User Four', 32),
  ('user5@example.com', '$2a$12$zRBuZA2JwumDt2cmm./PguY96L.vWMCMZmwKlWJbYKu3MP8OhZsze', 'USER', 'User Five', 29),
  ('admin@example.com', '$2a$12$1l5zqxajq/TTD18m9IYpweHcZZL2SVIxqE2UcQj.NVcM9zVzphUe2', 'ADMIN', 'Admin User', 35);

  INSERT INTO notes (USER_EMAIL, title, content)
  VALUES
    ('user1@example.com', 'Note 1', 'Content of Note 1'),
    ('user1@example.com', 'Note 2', 'Content of Note 2'),
    ('user1@example.com', 'Note 3', 'Content of Note 3'),
    ('user1@example.com', 'Note 4', 'Content of Note 4'),
    ('user1@example.com', 'Note 5', 'Content of Note 5'),

    ('user2@example.com', 'Note 1', 'Content of Note 1'),
    ('user2@example.com', 'Note 2', 'Content of Note 2'),
    ('user2@example.com', 'Note 3', 'Content of Note 3'),
    ('user2@example.com', 'Note 4', 'Content of Note 4'),
    ('user2@example.com', 'Note 5', 'Content of Note 5'),

    ('user3@example.com', 'Note 1', 'Content of Note 1'),
    ('user3@example.com', 'Note 2', 'Content of Note 2'),
    ('user3@example.com', 'Note 3', 'Content of Note 3'),
    ('user3@example.com', 'Note 4', 'Content of Note 4'),
    ('user3@example.com', 'Note 5', 'Content of Note 5'),

    ('user4@example.com', 'Note 1', 'Content of Note 1'),
    ('user4@example.com', 'Note 2', 'Content of Note 2'),
    ('user4@example.com', 'Note 3', 'Content of Note 3'),
    ('user4@example.com', 'Note 4', 'Content of Note 4'),
    ('user4@example.com', 'Note 5', 'Content of Note 5'),

    ('user5@example.com', 'Note 1', 'Content of Note 1'),
    ('user5@example.com', 'Note 2', 'Content of Note 2'),
    ('user5@example.com', 'Note 3', 'Content of Note 3'),
    ('user5@example.com', 'Note 4', 'Content of Note 4'),
    ('user5@example.com', 'Note 5', 'Content of Note 5');