import { Image } from "@/app/types/Types";
import { image } from "@nextui-org/react";
import React, { useState } from "react";
type Props = {
  images: Image[];
};

const CarouselArrow = ({
  direction,
  onClick,
}: {
  direction: "left" | "right";
  onClick: () => void;
}) => (
  <button
    onClick={onClick}
    className={`absolute top-1/2 transform -translate-y-1/2 ${
      direction === "left" ? "left-4" : "right-4"
    } p-2 rounded-full shadow-md cursor-pointer z-10`}
    style={{
      background:
        "linear-gradient(to bottom, rgba(255, 255, 255, 0.9), rgba(255, 255, 255, 0.4))",
      transition: "background-color 0.3s",
    }}
    onMouseEnter={(e) => {
      e.currentTarget.style.backgroundColor = "rgba(229, 231, 235, 0.5)";
    }}
    onMouseLeave={(e) => {
      e.currentTarget.style.backgroundColor = "transparent";
    }}
  >
    {direction === "left" ? (
      <svg
        xmlns="http://www.w3.org/2000/svg"
        width="24"
        height="24"
        viewBox="0 0 24 24"
        fill="none"
        stroke="currentColor"
        strokeWidth="2"
        strokeLinecap="round"
        strokeLinejoin="round"
        className="feather feather-chevron-left"
      >
        <polyline points="15 18 9 12 15 6"></polyline>
      </svg>
    ) : (
      <svg
        xmlns="http://www.w3.org/2000/svg"
        width="24"
        height="24"
        viewBox="0 0 24 24"
        fill="none"
        stroke="currentColor"
        strokeWidth="2"
        strokeLinecap="round"
        strokeLinejoin="round"
        className="feather feather-chevron-right"
      >
        <polyline points="9 18 15 12 9 6"></polyline>
      </svg>
    )}
  </button>
);

export const Carousel = ({ images }: Props) => {
  const [activeIndex, setActiveIndex] = useState(0);

  const goToPrevSlide = () => {
    setActiveIndex((prevIndex) =>
      prevIndex > 0 ? prevIndex - 1 : images.length - 1
    );
  };

  const goToNextSlide = () => {
    setActiveIndex((prevIndex) => (prevIndex + 1) % images.length);
  };
  return (
    <div className="flex flex-col items-center justify-center bg-opacity-100 backdrop-blur-md bg-white rounded-xl shadow-lg overflow-hidden my-4 p-4 mx-auto w-full md:w-2/3">
      <div className="relative w-full h-96 overflow-hidden">
        {images.map((image, index) => (
          <div
            key={image.id}
            className={`absolute inset-0 transition-transform duration-300 ease-in-out`}
            style={{
              transform: `translateX(${(index - activeIndex) * 100}%)`,
            }}
          >
            <img
              src={image.url}
              alt={`image ${index}`}
              className="w-full h-full object-contain"
            />
          </div>
        ))}
        {images.length > 1 && (
          <>
            <CarouselArrow direction="left" onClick={goToPrevSlide} />
            <CarouselArrow direction="right" onClick={goToNextSlide} />
          </>
        )}
        <div className="absolute bottom-4 left-0 right-0 flex justify-center z-10">
          {images.map((_, index) => (
            <div
              key={index}
              className={`w-3 h-3 mx-1 rounded-full ${
                index === activeIndex ? "bg-neutral" : "bg-gray-300"
              }`}
              onClick={() => setActiveIndex(index)}
            ></div>
          ))}
        </div>
      </div>
    </div>
  );
};
