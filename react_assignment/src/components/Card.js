import React from "react";
import { Link } from "react-router-dom";
import { FaRupeeSign } from 'react-icons/fa';
import { AiFillStar } from "react-icons/ai";

function Card(props) {
  const { book } = props;
  return (
    <div className="card">
      <img src={book.img} alt={book.name} />
      <p>{book.name}</p>
      <p className="card-author">{book.author}</p>
      <div className="card-footer">
        <p><FaRupeeSign size={15} />{book.price}</p>
        <p><AiFillStar size={15} color={"orange"}/>{book.rating}</p>
      </div>
      <div className="card-btn">
        <Link to={`/book/${book.id}`} className="navigate-btn">
          details
        </Link>
      </div>
    </div>
  );
}

export default Card;
