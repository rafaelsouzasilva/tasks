CREATE TABLE public.tasks (
    id UUID DEFAULT random_uuid() NOT NULL,
    name VARCHAR(200) NOT NULL,
    description VARCHAR(200),
    status VARCHAR(200) NOT NULL,
    createdAt TIMESTAMP DEFAULT NOW(),
    updatedAt TIMESTAMP DEFAULT NOW(),
    category_id UUID NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);
