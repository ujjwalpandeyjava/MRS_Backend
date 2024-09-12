import { useEffect, useRef } from 'react';
import { Col, Container, Row } from 'react-bootstrap';
import { useParams } from 'react-router-dom';
import apiBase from '../../api/apiBase';
import ReviewForm from '../reviewForm/ReviewForm';
import './Review.css';
import Swal from "sweetalert2";



function Review({ getMovieData, movie, reviews, setReviews }) {
	const revText = useRef();
	let params = useParams();
	const movieId = params.movieId;

	useEffect(() => {
		getMovieData(movieId);
		// comment to remove error of missing dependency with array/object type
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, []);

	const addReview = async (e) => {
		e.preventDefault();
		const rev = revText.current;
		const response = await apiBase.post("api/v1/reviews", { reviewBody: rev.value, imdbId: movieId });
		console.log(response);
		if (response.status === 201) {
			Swal.fire(
				'Saved successfully',
				'',
				'success'
			)
		}
		const updatedReviews = [...reviews, { body: rev.value, id: { date: new Date().toString(), timestamp: new Date().getTime() } }];
		setReviews(updatedReviews);
		rev.value = ``;
	}

	const formatDateTime = (dateTime, format) => {
		let dateToChange = new Date(dateTime);
		return dateToChange.toLocaleString(undefined, {
			format: format
		});
	}

	return (
		<Container>
			<Row>
				<Col><div className='videoTitle'>{movie.title}</div></Col>
			</Row>
			<Row>
				<Col>
					<img src={movie?.poster} alt='Movie poster' />
				</Col>
				<Col>
					{<>
						<Row>
							<Col>
								<ReviewForm handleSubmit={addReview} revText={revText} labelText="Write a review" />
							</Col>
						</Row>
						<Row>
							<Col>
								<hr />
							</Col>
						</Row>
					</>}
					{reviews?.length > 0 ?
						<Col className='commentSection'>
							{reviews?.map((eachReview, index) => {
								return (
									<Row className='eachComment' key={eachReview.id.timestamp}>
										<Col>{index + 1}. {eachReview.body}</Col>
										<Col style={{ color: "gray", fontSize: "xx-small", textAlign: "end" }} xs={4}>{formatDateTime(eachReview.id.date, "DD/MM/YYYY, hh:mm a")}</Col>
									</Row>
								)
							})}
						</Col> :
						null
					}
				</Col>
			</Row>
		</Container>
	)
}

export default Review