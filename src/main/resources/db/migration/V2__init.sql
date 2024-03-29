INSERT INTO users (EMAIL, PASSWORD_HASH, ROLE, NAME, AGE)
VALUES
  ('user1@example.com', '{noop}password123', 'USER', 'User One', 30),
  ('user2@example.com', '{noop}password456', 'USER', 'User Two', 25),
  ('user3@example.com', '{noop}password789', 'USER', 'User Three', 28),
  ('user4@example.com', '{noop}passwordabc', 'USER', 'User Four', 32),
  ('user5@example.com', '{noop}passworddef', 'USER', 'User Five', 29),
  ('admin@example.com', '{noop}adminpassword', 'ADMIN', 'Admin User', 35);

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