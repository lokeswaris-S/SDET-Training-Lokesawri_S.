-- 1. Display all records from each table for verification

SELECT * FROM tUser;
SELECT * FROM tFriends;
SELECT * FROM tPosts;
SELECT * FROM tComments;

-- 2. Get full details of a user by using their username

SELECT *
FROM tUser
WHERE username = 'Loki';

-- 3. Show all posts of a specific user (latest post first)

SELECT 
    p.post_id,
    p.content,
    p.image_url,
    p.created_at,
    p.likes_count,
    u.username
FROM tPosts p
INNER JOIN tUser u 
    ON p.user_id = u.user_id
WHERE u.username = 'Lokeswari'
ORDER BY p.created_at DESC;

-- 4. List accepted friends of a user

SELECT 
    f.friendship_id,
    u.username AS owner,
    fr.username AS friend,
    f.status,
    f.created_at
FROM tFriends f
INNER JOIN tUser u 
    ON f.user_id = u.user_id
INNER JOIN tUser fr 
    ON f.friend_id = fr.user_id
WHERE u.username = 'Lokeswari'
  AND f.status = 'accepted';

-- 5. Display posts which have more than 10 likes

SELECT 
    p.post_id,
    u.username,
    p.content,
    p.likes_count,
    p.created_at
FROM tPosts p
JOIN tUser u 
    ON p.user_id = u.user_id
WHERE p.likes_count > 10
ORDER BY p.likes_count DESC;

-- 6. Find users who did not post anything in the last 30 days

SELECT u.user_id, u.username
FROM tUser u
WHERE u.user_id NOT IN (
    SELECT DISTINCT user_id
    FROM tPosts
    WHERE created_at >= NOW() - INTERVAL 30 DAY
);

-- 7. Calculate average number of posts per user

SELECT 
    COUNT(p.post_id) / COUNT(DISTINCT u.user_id) AS avg_posts_per_user
FROM tUser u
LEFT JOIN tPosts p 
    ON u.user_id = p.user_id;

-- 8. Find Top 5 users having highest number of accepted friends

SELECT 
    u.username,
    COUNT(tf.friendship_id) AS total_friends
FROM tFriends tf
JOIN tUser u 
    ON (u.user_id = tf.user_id OR u.user_id = tf.friend_id)
WHERE tf.status = 'accepted'
GROUP BY u.user_id, u.username
ORDER BY total_friends DESC
LIMIT 5;

-- 9. Show all comments of a given post along with commenter details

SELECT 
    c.comment_id,
    u.username,
    u.email,
    c.comment_text,
    c.created_at
FROM tComments c
JOIN tUser u 
    ON c.user_id = u.user_id
WHERE c.post_id = 2
ORDER BY c.created_at;

-- 10. Find mutual friends between two users

SELECT DISTINCT u.username AS MutualFriend
FROM tFriends f1
JOIN tFriends f2 
     ON f1.friend_id = f2.friend_id
JOIN tUser u 
     ON u.user_id = f1.friend_id
WHERE f1.user_id = (SELECT user_id FROM tUser WHERE username = 'HARI')
  AND f2.user_id = (SELECT user_id FROM tUser WHERE username = 'KRISHNA')
  AND f1.status = 'accepted'
  AND f2.status = 'accepted';

-- 11. Delete posts which are older than 1 year

SET SQL_SAFE_UPDATES = 0;

DELETE FROM tPosts
WHERE created_at < NOW() - INTERVAL 1 YEAR;



