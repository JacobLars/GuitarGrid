import { Link } from "@nextui-org/react";
import React from "react";

export const Products = () => {
  return (
    <div className="mt-10">
      <h1 className="text-2xl text-center underline">Our Products</h1>
      <div className="flex flex-col h-10 items-center">
        <Link
          href="/selection"
          className="flex flex-col items-center border border-neutral-500 m-5 w-52 shadow-md"
        >
          <img
            className="h-52"
            src="https://m.media-amazon.com/images/I/51PeivonywL.jpg"
          ></img>
          <p>Guitars</p>
        </Link>
        <Link
          href="/products/tuners"
          className="flex flex-col items-center border border-neutral-500 m-5 w-52 shadow-md"
        >
          <img
            className="h-52"
            src="https://m.media-amazon.com/images/I/41duhgZ9KgL._AC_.jpg"
          ></img>
          <p>Tuners</p>
        </Link>
      </div>
    </div>
  );
};
