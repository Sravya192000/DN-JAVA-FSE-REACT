import React from "react";

function BlogDetails(){

    const blogs=[
        {
            id:1,
            title:"React Learning",
            author:"Stephen Biz",
            desc:"Welcome to learning React!"
        },
        {
            id:2,
            title:"Installation",
            author:"Schwezdenier",
            desc:"You can install React from npm."
        }
    ];

    return(
        <div className="column">
            <h1>Blog Details</h1>

            {blogs.map(blog=>(
                <div key={blog.id}>
                    <h2>{blog.title}</h2>
                    <h3>{blog.author}</h3>
                    <p>{blog.desc}</p>
                </div>
            ))}
        </div>
    );
}

export default BlogDetails;