import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import books from "../utils/data.js";

function SingleBook(props) {
  let { id } = useParams();
  id = parseInt(id);
  const [book, setBook] = useState(null);
  const getDetails = () => {
    const nbook = books.filter((book) => {
      return book.id === id;
    });
    setBook(nbook[0]);
  };

  useEffect(() => {
    getDetails();
  }, []);
  return (
    book != null && (
      <div>
        <div className="bookHeading">
          <div>
            <h5>{book.name}</h5>
            <p>{book.author}</p>
          </div>
          <div>
            <p>Rating</p>
            <p>{book.rating}</p>
          </div>
        </div>
        
        <div className="img-container">
          <img className="book-img" src={book.img} alt={book.name} />
          <span>{book.desc}</span>
        </div>

        <div className="book-footer">
          <div>
            <p>Price</p>
            <p>{book.price}</p>
          </div>
          <div>
            <p>Page count</p>
            <p>{book.pages_count}</p>
          </div>
          <div>
            <p>Languages</p>
            <p>
              {book.languages.map((lan, index) => {
                if (index === book.languages.length - 1) return `${lan}`;
                else return `${lan}, `;
              })}
            </p>
          </div>
        </div>
        <div className="btn-container">
            <Link to={`/`} className="navigate-btn">
            Home
            </Link>
        </div>
      </div>
    )
  );
}

export default SingleBook;
